package eu.mshade.enderframe.tick;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class TickBus implements Runnable {

    private static final long SLEEP_PRECISION = TimeUnit.MILLISECONDS.toNanos(2);

    private final Queue<Tickable> tickables = new ConcurrentLinkedQueue<>();
    public long nanoTimePerTick;
    private long curTick;
    private int tick;
    private double tps;

    private long lastTick;


    public TickBus(int tick) {
        this.tick = tick;
        this.tps = tick;
        this.nanoTimePerTick = (long) (1E9 / tick);
    }

    @Override
    public void run() {
        lastTick = System.nanoTime();
        long lastTickTps = lastTick;

        while (true) {
            final long curTime = System.nanoTime();
            final long wait = nanoTimePerTick - ((curTime - lastTick));

            if (wait > 0) {
                try {
                    sleepNanos(wait);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }else {
                if (++curTick % tick == 0){
                    double deltaTime = ((curTime - lastTickTps) / 1E9);
                    tps =  tick * (1 /  deltaTime);
                    lastTickTps = curTime;
                }

                lastTick = curTime;

                List<CompletableFuture<TickState>> completableFutures = new ArrayList<>();
                for (Tickable tickable : this.tickables) {
                    CompletableFuture<TickState> completableFuture = new CompletableFuture<>();
                    completableFutures.add(completableFuture);
                    ForkJoinPool.commonPool().execute(() -> {
                        tickable.tick();
                        tickable.addTick();
                        completableFuture.complete(tickable.getTickState());
                    });
                }

                try {
                    Void unused = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    public double getTPS() {
        return tps;
    }

    public void addTickable(Tickable tickable){
        this.tickables.add(tickable);
    }

    public void removeTickable(Tickable tickable){
        this.tickables.remove(tickable);
    }


    private void sleepNanos(long nanoDuration) throws InterruptedException {
        final long end = System.nanoTime() + nanoDuration;


        long timeLeft = nanoDuration;
        do {
            if (timeLeft > SLEEP_PRECISION)
                Thread.sleep(1);
            else
                Thread.yield();
            timeLeft = end - System.nanoTime();

            if (Thread.interrupted())
                throw new InterruptedException();

        } while (timeLeft > 0);

    }
}

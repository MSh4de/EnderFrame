package eu.mshade.enderframe.tick;

import eu.mshade.enderframe.UniqueId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.*;

public class TickBus implements Runnable {

    private static final long SLEEP_PRECISION = TimeUnit.MILLISECONDS.toNanos(2);
    private static final Logger LOGGER = LoggerFactory.getLogger(TickBus.class);
    public static final UniqueId TICKABLE_ID = new UniqueId();

    private final Map<Integer, Tickable> tickables = new ConcurrentHashMap<>();
    public long nanoTimePerTick;
    private long curTick;
    private int tick;
    private int tickPerSecond;
    private double tps;
    private long lastTick;

    public TickBus(int tick) {
        this.tick = tick;
        this.tps = tick;
        this.tickPerSecond = 1000 / tick;
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
            } else {
                if (++curTick % tick == 0) {
                    double deltaTime = ((curTime - lastTickTps) / 1E9);
                    tps = tick * (1 / deltaTime);
                    lastTickTps = curTime;
                }

                lastTick = curTime;

                List<CompletableFuture<TickState>> completableFutures = new ArrayList<>();
                for (Tickable tickable : this.tickables.values()) {
                    CompletableFuture<TickState> completableFuture = new CompletableFuture<>();
                    if (tickable.getTickState() == TickState.PROCESS) {
                        LOGGER.warn("Tickable {} is still processing from last tick, please optimize it!", tickable.getClass().getSimpleName());
                        continue;
                    }
                    completableFutures.add(completableFuture);
                    ForkJoinPool.commonPool().execute(() -> {
                        tickable.setTickState(TickState.PROCESS);
                        long start = System.currentTimeMillis();
                        try {
                            tickable.tick();
                        } catch (Exception e) {
                            LOGGER.error("Error while ticking tickable {}", tickable.getClass().getSimpleName(), e);
                        }
                        tickable.setTickState(TickState.WAITING);
                        long end = System.currentTimeMillis();
                        if (end - start > tickPerSecond) {
                            LOGGER.warn("Tickable {} took {}ms to tick ({}ms is the max) please optimize it!", tickable.getClass().getSimpleName(), end - start, tickPerSecond);
                        }
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

    public void addTickable(Tickable tickable) {
        this.tickables.put(tickable.getTickId(), tickable);
    }

    public void removeTickable(Tickable tickable) {
        this.tickables.remove(tickable.getTickId());
        TICKABLE_ID.flushId(tickable.getTickId());
    }

    public Collection<Tickable> getTickables() {
        return this.tickables.values();
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

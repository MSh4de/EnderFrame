package eu.mshade.enderframe.tick;

public abstract class Tickable {

    private long tick;

    private TickBus tickBus;

    private TickState tickState = TickState.WAITING;


    public abstract void tick();

    public boolean isPeriod(int period){
        return tick % period == 0;
    }

    public void addTick(){
        this.tick++;
    }

    public long getTick() {
        return tick;
    }

    public void resetTick(){
        this.tick = 0;
    }
    public TickState getTickState() {
        return tickState;
    }

    public void setTickState(TickState tickState) {
        this.tickState = tickState;
    }

    public void joinTickBus(TickBus tickBus){
        this.tickBus = tickBus;
        tickBus.addTickable(this);
    }

    public void leaveTickBus(){
        if (this.tickBus != null) {
            tickBus.removeTickable(this);
            tickBus = null;
        }
    }
}

package eu.mshade.enderframe.entity;

public enum CreeperState {
    IDLE(-1),
    FUSE(1);

    private final int state;

    CreeperState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}

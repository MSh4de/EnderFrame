package eu.mshade.enderframe.world.border;

public enum WorldBorderAction {

    SET_SIZE(0),
    CHANGE_SIZE(1),
    SET_CENTER(2),
    INITIALIZE(3),
    SET_WARNING_TIME(4),
    SET_WARNING_BLOCKS(5);

    private final int action;

    WorldBorderAction(int action) {
        this.action = action;
    }

    public int getAction() {
        return action;
    }
}

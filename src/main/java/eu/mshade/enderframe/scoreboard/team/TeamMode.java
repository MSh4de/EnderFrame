package eu.mshade.enderframe.scoreboard.team;

public enum TeamMode {

    CREATE_TEAM(0),
    REMOVE_TEAM(1),
    UPDATE_TEAM_INFOS(2),
    ADD_PLAYER(3),
    REMOVE_PLAYER(4);

    private final int mode;

    TeamMode(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }
}

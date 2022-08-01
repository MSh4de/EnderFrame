package eu.mshade.enderframe.scoreboard;

public enum ScoreboardPosition {

    LIST(0),
    SIDEBAR(1),
    BELOW_NAME(2);

    private final int position;

    ScoreboardPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}

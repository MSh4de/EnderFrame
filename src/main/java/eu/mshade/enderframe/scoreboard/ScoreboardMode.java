package eu.mshade.enderframe.scoreboard;

public enum ScoreboardMode {

    CREATE(0),
    REMOVE(1),
    UPDATE_DISPLAY_TEXT(2);

    private int mode;

    ScoreboardMode(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }
}

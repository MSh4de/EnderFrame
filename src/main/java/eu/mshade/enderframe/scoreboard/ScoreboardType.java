package eu.mshade.enderframe.scoreboard;

public enum ScoreboardType {

    HEARTS("hearts"),
    INTEGER("integer");

    private final String type;

    ScoreboardType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

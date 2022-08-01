package eu.mshade.enderframe.scoreboard.objective;

public enum ScoreboardObjectiveAction {

    CREATE_OR_UPDATE(0),
    REMOVE(1);

    private int action;

    ScoreboardObjectiveAction(int action) {
        this.action = action;
    }

    public int getAction() {
        return action;
    }
}

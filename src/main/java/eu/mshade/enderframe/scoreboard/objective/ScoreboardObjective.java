package eu.mshade.enderframe.scoreboard.objective;

import eu.mshade.enderframe.scoreboard.Scoreboard;
import eu.mshade.mwork.ShrinkingUUID;

public class ScoreboardObjective<T> {

    protected final String objectiveId = ShrinkingUUID.randomUUID(12);
    protected final Scoreboard<?> scoreboard;
    protected T objective;
    protected int objectiveValue;

    public ScoreboardObjective(Scoreboard<?> scoreboard, T objective, int objectiveValue) {
        this.scoreboard = scoreboard;
        this.objective = objective;
        this.objectiveValue = objectiveValue;
    }

    public String getObjectiveId() {
        return objectiveId;
    }

    public T getObjective() {
        return objective;
    }

    public ScoreboardObjective<T> setObjectiveName(T objectiveName) {
        this.objective = objectiveName;
        return this;
    }

    public int getObjectiveValue() {
        return objectiveValue;
    }

    public ScoreboardObjective<T> setObjectiveValue(int objectiveValue) {
        this.objectiveValue = objectiveValue;
        return this;
    }

    public Scoreboard<?> getScoreboard() {
        return scoreboard;
    }
}

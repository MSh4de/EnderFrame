package eu.mshade.enderframe.scoreboard;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.protocol.SessionWrapper;
import eu.mshade.enderframe.scoreboard.objective.ScoreboardObjective;
import eu.mshade.enderframe.scoreboard.objective.ScoreboardObjectiveAction;
import eu.mshade.mwork.ShrinkingUUID;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.function.Function;

public class Scoreboard<T> {

    protected final String scoreboardId = ShrinkingUUID.randomUUID(12);

    protected TextComponent scoreboardName;
    protected ScoreboardPosition scoreboardPosition;
    protected ScoreboardType scoreboardType;
    protected Queue<Player> viewers = new ConcurrentLinkedQueue<>();
    protected List<ScoreboardObjective<T>> objectives = new ArrayList<>();

    public Scoreboard(TextComponent scoreboardName) {
        this.scoreboardName = scoreboardName;
    }

    public void showScoreboard(Player player) {
        viewers.add(player);
        player.getLookAtScoreboard().add(this);

        SessionWrapper sessionWrapper = player.getSessionWrapper();

        sessionWrapper.sendScoreboardObjective(this, ScoreboardMode.CREATE);
        sessionWrapper.sendDisplayScoreboard(this);

        for (ScoreboardObjective<T> objective : this.objectives) {
            sessionWrapper.sendUpdateScoreboard(objective, ScoreboardObjectiveAction.CREATE_OR_UPDATE);
        }
    }

    public void hideScoreboard(Player player) {
        viewers.remove(player);

        player.getLookAtScoreboard().remove(this);
        player.getSessionWrapper().sendScoreboardObjective(this, ScoreboardMode.REMOVE);
    }

    public Scoreboard<T> addObjective(T objective, int objectiveValue) {
        ScoreboardObjective<T> scoreboardObjective = new ScoreboardObjective<>(this, objective, objectiveValue);

        this.objectives.add(scoreboardObjective);

        for (Player viewer : this.viewers) {
            viewer.getSessionWrapper().sendUpdateScoreboard(scoreboardObjective, ScoreboardObjectiveAction.CREATE_OR_UPDATE);
        }

        return this;
    }

    public void modifyObjective(int index, Consumer<ScoreboardObjective<T>> consumer) {
        ScoreboardObjective<T> scoreboardObjective = this.objectives.get(index);
        consumer.accept(scoreboardObjective);

        for (Player viewer : this.viewers) {
            viewer.getSessionWrapper().sendUpdateScoreboard(scoreboardObjective, ScoreboardObjectiveAction.CREATE_OR_UPDATE);
        }
    }

    public void removeObjective(ScoreboardObjective<T> scoreboardObjective) {
        for (Player viewer : this.viewers) {
            viewer.getSessionWrapper().sendUpdateScoreboard(scoreboardObjective, ScoreboardObjectiveAction.REMOVE);
        }

        this.objectives.remove(scoreboardObjective);
    }

    public void removeObjective(int index) {
        this.removeObjective(this.objectives.get(index));
    }

    public void modifyScoreboardName(Function<TextComponent, TextComponent> function) {
        this.setScoreboardName(function.apply(scoreboardName));
    }

    public void setScoreboardName(TextComponent scoreboardName) {
        this.scoreboardName = scoreboardName;

        for (Player viewer : viewers) {
            viewer.getSessionWrapper().sendScoreboardObjective(this, ScoreboardMode.UPDATE_DISPLAY_TEXT);
        }
    }

    public Scoreboard<T> setScoreboardType(ScoreboardType scoreboardType) {
        this.scoreboardType = scoreboardType;
        return this;
    }

    public Scoreboard<T> setScoreboardPosition(ScoreboardPosition scoreboardPosition) {
        this.scoreboardPosition = scoreboardPosition;
        return this;
    }

    public String getScoreboardId() {
        return scoreboardId;
    }

    public ScoreboardPosition getScoreboardPosition() {
        return scoreboardPosition;
    }

    public ScoreboardType getScoreboardType() {
        return scoreboardType;
    }

    public TextComponent getScoreboardName() {
        return scoreboardName;
    }

    public Queue<Player> getViewers() {
        return viewers;
    }
}
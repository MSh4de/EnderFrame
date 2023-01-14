package eu.mshade.enderframe.scoreboard;

import eu.mshade.enderframe.Agent;
import eu.mshade.enderframe.Watchable;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.protocol.MinecraftSession;
import eu.mshade.enderframe.scoreboard.objective.ScoreboardObjective;
import eu.mshade.enderframe.scoreboard.objective.ScoreboardObjectiveAction;
import eu.mshade.mwork.ShrinkingUUID;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.function.Function;

public class Scoreboard<T> implements Watchable {

    protected final String scoreboardId = ShrinkingUUID.randomUUID(12);

    protected TextComponent scoreboardName;
    protected ScoreboardPosition scoreboardPosition;
    protected ScoreboardType scoreboardType;
    protected Queue<Agent> agents = new ConcurrentLinkedQueue<>();
    protected List<ScoreboardObjective<T>> objectives = new ArrayList<>();

    public Scoreboard(TextComponent scoreboardName) {
        this.scoreboardName = scoreboardName;
    }

    public void showScoreboard(Player player) {
        agents.add(player);
        player.getLookAtScoreboard().add(this);

        MinecraftSession minecraftSession = player.getMinecraftSession();

        minecraftSession.sendScoreboardObjective(this, ScoreboardMode.CREATE);
        minecraftSession.sendDisplayScoreboard(this);

        for (ScoreboardObjective<T> objective : this.objectives) {
            minecraftSession.sendUpdateScoreboard(objective, ScoreboardObjectiveAction.CREATE_OR_UPDATE);
        }
    }

    public void hideScoreboard(Player player) {
        agents.remove(player);

        player.getLookAtScoreboard().remove(this);
        player.getMinecraftSession().sendScoreboardObjective(this, ScoreboardMode.REMOVE);
    }

    public Scoreboard<T> addObjective(T objective, int objectiveValue) {
        ScoreboardObjective<T> scoreboardObjective = new ScoreboardObjective<>(this, objective, objectiveValue);

        this.objectives.add(scoreboardObjective);


        for (Agent viewer : this.getWatchers()) {
            if (viewer instanceof Player player) {
                player.getMinecraftSession().sendUpdateScoreboard(scoreboardObjective, ScoreboardObjectiveAction.CREATE_OR_UPDATE);
            }
        }

        return this;
    }

    public void modifyObjective(int index, Consumer<ScoreboardObjective<T>> consumer) {
        ScoreboardObjective<T> scoreboardObjective = this.objectives.get(index);
        consumer.accept(scoreboardObjective);

        for (Agent agent : this.getWatchers()) {
            if (agent instanceof Player player) {
                player.getMinecraftSession().sendUpdateScoreboard(scoreboardObjective, ScoreboardObjectiveAction.CREATE_OR_UPDATE);
            }
        }
    }

    public void removeObjective(ScoreboardObjective<T> scoreboardObjective) {
        for (Agent agent : this.getWatchers()) {
            if (agent instanceof Player player) {
                player.getMinecraftSession().sendUpdateScoreboard(scoreboardObjective, ScoreboardObjectiveAction.REMOVE);
            }
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

        for (Agent agent : this.getWatchers()) {
            if (agent instanceof Player player) {
                player.getMinecraftSession().sendScoreboardObjective(this, ScoreboardMode.UPDATE_DISPLAY_TEXT);
            }
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

    @Override
    public void addWatcher(Agent agent) {
        agents.add(agent);
    }

    @Override
    public void removeWatcher(Agent agent) {
        agents.remove(agent);
    }

    @Override
    public boolean isWatching(Agent agent) {
        return agents.contains(agent);
    }

    @Override
    public Collection<Agent> getWatchers() {
        return this.agents;
    }

    @Override
    public void notify(Consumer<Agent> sessionWrapperConsumer) {
        for (Agent agent : agents) {
            sessionWrapperConsumer.accept(agent);
        }
    }
}
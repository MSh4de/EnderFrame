package eu.mshade.enderframe.scoreboard

import eu.mshade.enderframe.Agent
import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.mojang.chat.TextComponent

class ScoreboardBelowName(textComponent: TextComponent, val entity: Entity) :
    Scoreboard(textComponent, ScoreboardPosition.BELOW_NAME, ScoreboardType.INTEGER), ScoreboardLine {

    private var score: Int = 0

    override fun getValue(): String {
        if (entity is Player) {
            return entity.name
        }
        return entity.uniqueId.toString()
    }

    override fun setValue(entry: String) {
        TODO("Not yet implemented")
    }

    override fun getScore(): Int {
        return score
    }

    override fun setScore(score: Int) {
        this.score = score
        notify(Player::class.java) {
            val minecraftSession = it.minecraftSession
            minecraftSession.sendUpdateScoreboardLine(this, this, ScoreboardLineAction.CHANGE)
        }
    }

    override fun addWatcher(agent: Agent) {
        super.addWatcher(agent)
        if (agent is Player) {
            val minecraftSession = agent.minecraftSession
            minecraftSession.sendUpdateScoreboardLine(this, this, ScoreboardLineAction.CHANGE)
        }
    }

    override fun clone(): ScoreboardLine {
        return ScoreboardBelowName(getTitle(), entity)
    }

}
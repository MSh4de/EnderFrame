package eu.mshade.enderframe.scoreboard

import eu.mshade.enderframe.Agent
import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.mojang.chat.TextComponent
import eu.mshade.enderframe.scoreboard.objective.ScoreboardObjectiveAction
import java.util.*

const val MAX_LINES = 16

class ScoreboardSidebar(title: TextComponent) : Scoreboard(title, ScoreboardPosition.SIDEBAR, ScoreboardType.INTEGER) {

    private val lines = mutableListOf<ScoreboardLine>()

    fun updateLine(l: Int, entry: String) {
        if (l > MAX_LINES) throw IllegalArgumentException("Index must be smaller than $MAX_LINES")

        if (lines.size <= l) {
            for (i in lines.size until l) {
                lines.add(DefaultScoreboardLine(this,"", i))
            }
            lines.add(DefaultScoreboardLine(this, entry, l))
            notify(Player::class.java) {
                val minecraftSession = it.minecraftSession
                minecraftSession.sendUpdateScoreboardLine(lines[l], ScoreboardObjectiveAction.CHANGE)
            }
            return
        }

        val line = lines[l]
        notify(Player::class.java) {
            val minecraftSession = it.minecraftSession
            minecraftSession.sendUpdateScoreboardLine(line, ScoreboardObjectiveAction.REMOVE)
        }
        line.setEntry(entry)
        notify(Player::class.java) {
            val minecraftSession = it.minecraftSession
            minecraftSession.sendUpdateScoreboardLine(line, ScoreboardObjectiveAction.CHANGE)
        }
    }

    fun updateLine(vararg entries: String) {
        if (entries.size > MAX_LINES) throw IllegalArgumentException("Index must be smaller than $MAX_LINES")
        for (i in entries.indices) {
            updateLine(i, entries[i])
        }
    }

    fun deleteLine(l: Int) {
        if (l > MAX_LINES) throw IllegalArgumentException("Index must be smaller than $MAX_LINES")
        val line = lines[l]
        notify(Player::class.java) {
            val minecraftSession = it.minecraftSession
            minecraftSession.sendUpdateScoreboardLine(line, ScoreboardObjectiveAction.REMOVE)
        }
        lines.removeAt(l)
    }

    override fun addWatcher(agent: Agent) {
        val add = viewers.add(agent)
        if (add) {
            val player = agent as? Player ?: return
            val minecraftSession = player.minecraftSession
            minecraftSession.sendScoreboard(this, ScoreboardMode.CREATE)
            minecraftSession.sendDisplayScoreboard(this)
            for (line in lines) {
                minecraftSession.sendUpdateScoreboardLine(line, ScoreboardObjectiveAction.CHANGE)
            }
        }
    }
}

interface ScoreboardLine {

    fun getEntry(): String

    fun setEntry(entry: String)

    fun getScore(): Int

    fun setScore(score: Int)

    fun getScoreboard(): Scoreboard

}

interface EntityScoreboardLine : ScoreboardLine {

    fun getEntity(): Entity

}

class DefaultScoreboardLine(private val scoreboard: Scoreboard, private var entry: String, private var score: Int, private val uniqueId: String = UUID.randomUUID().toString()) :
    ScoreboardLine {

    override fun getEntry(): String {
        return entry
    }

    override fun setEntry(entry: String) {
        this.entry = entry
    }

    override fun getScore(): Int {
        return score
    }

    override fun setScore(score: Int) {
        this.score = score
    }

    override fun getScoreboard(): Scoreboard {
        return scoreboard
    }


}
package eu.mshade.enderframe.scoreboard

import eu.mshade.enderframe.Agent
import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.mojang.chat.TextComponent
import eu.mshade.mwork.ShrinkingUUID
import java.util.function.Consumer

const val MAX_LINES = 15

class ScoreboardSidebar(title: TextComponent) : Scoreboard(title, ScoreboardPosition.SIDEBAR, ScoreboardType.INTEGER) {

    private val lines = mutableMapOf<String, ScoreboardLine>()


    fun modifyLine(key: String, modifier: Consumer<ScoreboardLine>){
        val scoreboardLine = lines[key]
        if (scoreboardLine != null) {
            val clone = scoreboardLine.clone()
            modifier.accept(scoreboardLine)
            if (scoreboardLine.getValue() != clone.getValue()){
                notify(Player::class.java) {
                    val minecraftSession = it.minecraftSession
                    minecraftSession.sendUpdateScoreboardLine(this, clone, ScoreboardLineAction.REMOVE)
                }
            }
            notify(Player::class.java) {
                val minecraftSession = it.minecraftSession
                minecraftSession.sendUpdateScoreboardLine(this, scoreboardLine, ScoreboardLineAction.CHANGE)
            }
        }else {
            val newScoreboardLine = DefaultScoreboardLine("NONE", MAX_LINES - lines.size)
            modifier.accept(newScoreboardLine)
            println(newScoreboardLine)
            lines[key] = newScoreboardLine
            notify(Player::class.java) {
                val minecraftSession = it.minecraftSession
                minecraftSession.sendUpdateScoreboardLine(this, newScoreboardLine, ScoreboardLineAction.CHANGE)
            }
        }
    }


    fun deleteLine(key: String) {
        val scoreboardLine = lines[key]
        if (scoreboardLine != null) {
            notify(Player::class.java) {
                val minecraftSession = it.minecraftSession
                minecraftSession.sendUpdateScoreboardLine(this, scoreboardLine, ScoreboardLineAction.REMOVE)
            }
            lines.remove(key)
        }
    }


    fun clear() {
        lines.forEach { (key, _) ->
            deleteLine(key)
        }
        lines.clear()
    }

    override fun addWatcher(agent: Agent) {
        if (isWatching(agent)) return
        viewers.add(agent)
        val player = agent as? Player ?: return
        val minecraftSession = player.minecraftSession
        minecraftSession.sendScoreboard(this, ScoreboardAction.CREATE)
        minecraftSession.sendDisplayScoreboard(this)
        for (line in lines.values) {
            minecraftSession.sendUpdateScoreboardLine(this, line, ScoreboardLineAction.CHANGE)
        }
    }
}

class DefaultScoreboardLine(
    private var value: String,
    private var score: Int
) :
    ScoreboardLine {

    override fun getValue(): String {
        return value
    }

    override fun setValue(entry: String) {
        this.value = entry
    }

    override fun getScore(): Int {
        return score
    }

    override fun setScore(score: Int) {
        this.score = score
    }


    override fun clone(): ScoreboardLine {
        return DefaultScoreboardLine(value, score)
    }

    override fun toString(): String {
        return "DefaultScoreboardLine(value='$value', score=$score)"
    }

}
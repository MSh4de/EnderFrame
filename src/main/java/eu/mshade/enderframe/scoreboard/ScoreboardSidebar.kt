package eu.mshade.enderframe.scoreboard

import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.mojang.chat.TextComponent
import java.util.UUID

class ScoreboardSidebar(title: TextComponent): Scoreboard(title, ScoreboardPosition.SIDEBAR, ScoreboardType.INTEGER) {

    private val lines = mutableListOf<ScoreboardLine>()

    fun updateLine(index: Int, entry: String) {
        val line = lines[index]
        line.setEntry(entry)
        notify(Player::class.java) {
            val minecraftSession = it.minecraftSession

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

interface EntityScoreboardLine: ScoreboardLine {

    fun getEntity(): Entity

}

class DefaultScoreboardLine(val uniqueId: String = UUID.randomUUID().toString(), var entry: String, var score: Int): ScoreboardLine {

    override fun getEntry(): String {
        TODO("Not yet implemented")
    }

    override fun setEntry(entry: String) {
        TODO("Not yet implemented")
    }

    override fun getScore(): Int {
        TODO("Not yet implemented")
    }

    override fun setScore(score: Int) {
        TODO("Not yet implemented")
    }

    override fun getScoreboard(): Scoreboard {
        TODO("Not yet implemented")
    }


}
package eu.mshade.enderframe.scoreboard

import eu.mshade.enderframe.Agent
import eu.mshade.enderframe.UniqueId
import eu.mshade.enderframe.Watchable
import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.mojang.chat.TextComponent
import java.util.concurrent.ConcurrentLinkedQueue

typealias TextComponentModifier = (TextComponent) -> TextComponent

abstract class Scoreboard(
    private var title: TextComponent, val scoreboardPosition: ScoreboardPosition, val scoreboardType: ScoreboardType
) : Watchable {


    companion object {
        val uniqueId = UniqueId()
    }

    private val id = "sb-" + uniqueId.freeId
    protected val viewers = ConcurrentLinkedQueue<Agent>()

    fun getId(): String {
        return id
    }

    override fun addWatcher(agent: Agent) {
        val add = viewers.add(agent)
        if (add) {
            val player = agent as? Player ?: return
            val minecraftSession = player.minecraftSession
            minecraftSession.sendScoreboard(this, ScoreboardAction.CREATE)
            minecraftSession.sendDisplayScoreboard(this)
        }
    }

    override fun removeWatcher(agent: Agent) {
        if (!this.isWatching(agent)) return
        viewers.remove(agent)
        val player = agent as? Player ?: return
        val minecraftSession = player.minecraftSession
        minecraftSession.sendScoreboard(this, ScoreboardAction.REMOVE)
    }

    override fun isWatching(agent: Agent?): Boolean {
        return viewers.contains(agent)
    }

    override fun getWatchers(): MutableCollection<Agent> {
        return viewers
    }

    fun getTitle(): TextComponent {
        return title
    }

    open fun modifyTitle(modifier: TextComponentModifier) {
        title = modifier(title)
        notify(Player::class.java) {
            val minecraftSession = it.minecraftSession
            minecraftSession.sendScoreboard(this, ScoreboardAction.UPDATE_DISPLAY_TEXT)
        }
    }


}

interface ScoreboardLine : Cloneable {

    fun getValue(): String

    fun setValue(entry: String)

    fun getScore(): Int

    fun setScore(score: Int)

    public override fun clone(): ScoreboardLine {
        TODO("Not yet implemented")
    }

}

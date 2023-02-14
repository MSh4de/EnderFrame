package eu.mshade.enderframe.scoreboard

import eu.mshade.enderframe.Agent
import eu.mshade.enderframe.Watchable
import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.mojang.chat.TextComponent
import java.util.UUID
import java.util.concurrent.ConcurrentLinkedQueue

typealias TextComponentModifier = (TextComponent) -> TextComponent

abstract class Scoreboard(
    private var title: TextComponent, val scoreboardPosition: ScoreboardPosition, val scoreboardType: ScoreboardType
) : Watchable {

    protected val viewers = ConcurrentLinkedQueue<Agent>()
    val id = UUID.randomUUID().toString()

    override fun addWatcher(agent: Agent) {
        val add = viewers.add(agent)
        if (add) {
            val player = agent as? Player ?: return
            val minecraftSession = player.minecraftSession
            minecraftSession.sendScoreboard(this, ScoreboardMode.CREATE)
            minecraftSession.sendDisplayScoreboard(this)
        }
    }

    override fun removeWatcher(agent: Agent) {
        val remove = viewers.remove(agent)
        if (remove) {
            val player = agent as? Player ?: return
            val minecraftSession = player.minecraftSession
            minecraftSession.sendScoreboard(this, ScoreboardMode.REMOVE)
        }

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

    fun modifyTitle(modifier: TextComponentModifier) {
        title = modifier(title)

        notify(Player::class.java) {
            val minecraftSession = it.minecraftSession
            minecraftSession.sendScoreboard(this, ScoreboardMode.UPDATE_DISPLAY_TEXT)
        }

    }

}

class ScoreboardBelowName(textComponent: TextComponent) : Scoreboard(textComponent, ScoreboardPosition.BELOW_NAME, ScoreboardType.INTEGER) 
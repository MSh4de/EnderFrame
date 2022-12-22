package eu.mshade.enderframe

import java.util.function.Consumer

interface Watchable {

    fun addWatcher(agent: Agent?)

    fun removeWatcher(agent: Agent?)

    fun isWatching(agent: Agent?): Boolean

    fun getWatchers(): Collection<Agent>

    fun notify(agent: Consumer<Agent?>?)

    fun <T : Agent?> notify(type: Class<T>, consumer: Consumer<T>) {
        notify { agent: Agent? -> if (type.isInstance(agent)) consumer.accept(type.cast(agent)) }
    }
}
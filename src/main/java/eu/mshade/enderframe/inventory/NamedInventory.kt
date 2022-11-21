package eu.mshade.enderframe.inventory

import eu.mshade.enderframe.Agent
import eu.mshade.enderframe.Watchable
import eu.mshade.enderframe.item.ItemStack
import eu.mshade.enderframe.mojang.chat.TextComponent
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.function.Consumer

open class NamedInventory : Inventory, Watchable {

    val name: TextComponent
    private val watchers = ConcurrentLinkedQueue<Agent>()

    constructor(name: String, inventoryKey: InventoryKey) : super(inventoryKey) {
        this.name = TextComponent.of(name)
    }

    constructor(name: TextComponent, inventoryKey: InventoryKey) : super(inventoryKey) {
        this.name = name
    }

    constructor(name: TextComponent, inventoryKey: InventoryKey, vararg itemStack: ItemStack) : super(
        inventoryKey,
        itemStack
    ) {
        this.name = name
    }

    override fun addWatcher(agent: Agent) {
        watchers.add(agent)
    }

    override fun removeWatcher(agent: Agent) {
        watchers.remove(agent)
    }

    override fun getWatcher(): MutableCollection<Agent> {
        return watchers
    }

    override fun isWatching(agent: Agent): Boolean {
        return watchers.contains(agent)
    }

    override fun notify(agent: Consumer<Agent>) {
        watchers.forEach { agent.accept(it) }
    }


}
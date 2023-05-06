package eu.mshade.enderframe.inventory

import eu.mshade.enderframe.Agent
import eu.mshade.enderframe.Watchable
import eu.mshade.enderframe.item.ItemStack
import eu.mshade.enderframe.item.Material
import eu.mshade.enderframe.item.MaterialKey
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.function.Consumer
import java.util.function.Function

abstract class Inventory(var inventoryKey: InventoryKey, @JvmField var itemStacks: Array<ItemStack?>, var uniqueId: UUID) :
    Watchable {
    protected var updateSlots: MutableList<Int> = ArrayList()
    protected var agents: Queue<Agent> = ConcurrentLinkedQueue()

    init {
        InventoryRepository.add(this)
    }

    constructor(inventoryKey: InventoryKey, uniqueId: UUID) : this(
        inventoryKey,
        arrayOfNulls<ItemStack>(inventoryKey.defaultSlot),
        uniqueId
    )

    open fun setItemStack(slot: Int, itemStack: ItemStack?) {
        if (itemStack != null && itemStack.material != null && itemStack.material != Material.AIR) itemStacks[slot] =
            itemStack else itemStacks[slot] = null
        updateSlots.add(slot)
    }

    open fun deleteItemStack(slot: Int) {
        itemStacks[slot] = null
        updateSlots.add(slot)
    }

    open fun getItemStack(slot: Int): ItemStack? {
        return itemStacks[slot]
    }

    open fun getItemStack(equipmentSlot: EquipmentSlot): ItemStack? {
        return getItemStack(equipmentSlot.ordinal)
    }

    open fun findFirstEmptySlot(): Int {
        return findFirstEmptySlot(0)
    }

    open fun findFirstEmptySlot(offset: Int): Int {
        for (i in offset until itemStacks.size) {
            getItemStack(i) ?: return i
        }
        return -1
    }

    fun findItemStack(materialKey: MaterialKey, filter: Function<ItemStack?, Boolean>): ItemStack? {
        return findItemStack(0, materialKey, filter)
    }

    fun findItemStack(offset: Int, materialKey: MaterialKey, filter: Function<ItemStack?, Boolean>): ItemStack? {
        for (i in offset until itemStacks.size) {
            val itemStack = getItemStack(i)
            if (itemStack == null || itemStack.material != materialKey) continue
            if (filter.apply(itemStack)) {
                return itemStack
            }
        }
        return null
    }

    val size: Int
        get() = itemStacks.size
    val rows: Int
        get() = size / 9

    fun fill(itemStacks: Array<ItemStack?>) {
        for (i in itemStacks.indices) {
            setItemStack(i, itemStacks[i])
        }
    }


    fun visitUpdateSlots(): Collection<Int> {
        val updateSlots: Collection<Int> = ArrayList(updateSlots)
        this.updateSlots.clear()
        return updateSlots
    }

    override fun addWatcher(agent: Agent) {
        agents.add(agent)
    }

    override fun removeWatcher(agent: Agent) {
        agents.remove(agent)
    }

    override fun getWatchers(): Collection<Agent> {
        return agents
    }

    override fun isWatching(agent: Agent): Boolean {
        return agents.contains(agent)
    }

}
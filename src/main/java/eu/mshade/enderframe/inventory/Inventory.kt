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

abstract class Inventory(var inventoryKey: InventoryKey, @JvmField var itemStacks: Array<ItemStack?>) : Watchable {
    protected var updateSlots: MutableList<Int> = ArrayList()
    protected var agents: Queue<Agent> = ConcurrentLinkedQueue()

    constructor(inventoryKey: InventoryKey) : this(
        inventoryKey,
        arrayOfNulls<ItemStack>(inventoryKey.defaultSlot),
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

    open fun setItemStack(equipmentSlot: EquipmentSlot, itemStack: ItemStack?) {
        setItemStack(equipmentSlot.ordinal, itemStack)
    }

    open fun findFirstEmptySlot(): Int {
        return findFirstEmptySlot(0)
    }

    open fun findFirstEmptySlot(offset: Int): Int {
        for (i in offset until itemStacks.size) {
            val itemStack = getItemStack(i)
            if (itemStack == null || itemStack.amount < itemStack.material.maxStackSize) return i
        }
        return -1
    }

    fun addItemStack(itemStack: ItemStack): Boolean {
        val (slot, foundItemStack) = findItemStack(itemStack.material) { item -> item != null && item.matchMetadata(itemStack) && item.amount < item.material.maxStackSize }
        if (foundItemStack == null || foundItemStack.amount >= itemStack.material.maxStackSize) {
            val findFirstEmptySlot = findFirstEmptySlot()
            if (findFirstEmptySlot != -1) {
                setItemStack(findFirstEmptySlot, itemStack)
                updateSlots.add(findFirstEmptySlot)
                return true
            }
            return false
        }

        if (foundItemStack.amount + itemStack.amount > itemStack.material.maxStackSize) {
            val rest = (foundItemStack.amount + itemStack.amount) - itemStack.material.maxStackSize
            foundItemStack.amount = itemStack.material.maxStackSize
            updateSlots.add(slot)

            val findFirstEmptySlot = findFirstEmptySlot()
            if (findFirstEmptySlot != -1) {
                setItemStack(findFirstEmptySlot, itemStack.clone().apply { amount = rest })
                updateSlots.add(findFirstEmptySlot)
                return true
            }
            return false
        }else {
            foundItemStack.modifyAmount { amount -> itemStack.amount + amount }
            updateSlots.add(slot)
        }
        return true
    }

    fun findItemStack(materialKey: MaterialKey, filter: Function<ItemStack?, Boolean>): Pair<Int, ItemStack?> {
        return findItemStack(0, materialKey, filter)
    }

    fun findItemStack(offset: Int, materialKey: MaterialKey, filter: Function<ItemStack?, Boolean>): Pair<Int, ItemStack?> {
        for (i in offset until itemStacks.size) {
            val itemStack = getItemStack(i)
            if (itemStack == null || itemStack.material != materialKey) continue
            if (filter.apply(itemStack)) {
                return Pair(i, itemStack)
            }
        }
        return Pair(-1, null)
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

    fun isInUpdateSlots(slot: Int): Boolean {
        return updateSlots.contains(slot)
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
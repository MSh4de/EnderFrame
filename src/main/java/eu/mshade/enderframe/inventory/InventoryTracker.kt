package eu.mshade.enderframe.inventory

import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.tick.Tickable
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue

object InventoryTracker : Tickable() {

    private val inventories = ConcurrentLinkedQueue<Inventory>()
    private val inventoriesByUniqueId = ConcurrentHashMap<UUID, Inventory>()

    override fun tick() {
        inventories.forEach {
            if (it !is PlayerInventory) {
                it.itemStacks.forEachIndexed { index, itemStack ->
                    run {
                        if (itemStack != null && (itemStack.visitModified() || itemStack.metadataKeyValueBucket.visitModified())) {
                            it.notify(Player::class.java) { player ->
                                player.minecraftSession.sendItemStack(it, index, it.getItemStack(index))
                            }
                        }
                    }
                }

                it.visitUpdateSlots().forEach { index ->
                    it.notify(Player::class.java) { player ->
                        player.minecraftSession.sendItemStack(it, index, it.getItemStack(index))
                    }
                }

            } else {
                it.itemStacks.forEachIndexed { index, itemStack ->
                    run {
                        if (itemStack != null && (itemStack.visitModified() || itemStack.metadataKeyValueBucket.visitModified())) {
                            updateItemStack(it, index)
                        }
                    }
                }

                it.visitUpdateSlots().forEach { index ->
                    updateItemStack(it, index)
                }
            }
        }
    }

    fun add(inventory: Inventory) {
        inventories.add(inventory)
        inventoriesByUniqueId[inventory.uniqueId] = inventory
    }

    fun remove(inventory: Inventory) {
        inventories.remove(inventory)
        inventoriesByUniqueId.remove(inventory.uniqueId)
    }

    private fun calculateRealIndex(player: Player, slot: Int): Int {
        if (player.openedInventory is PlayerInventory || player.openedInventory == null) return slot

        val openedInventory = player.openedInventory
        val maxSize = openedInventory.size
        val maxSizeSlotWithPlayerInventory: Int = maxSize + 9 * 4
        val firstSlotHotBar = maxSizeSlotWithPlayerInventory - 9
        if (slot <= 8) {
            return firstSlotHotBar + slot
        } else {
            return maxSize + (slot - 9)
        }

    }

    private fun itemSlotFromIndex(player: Player, slot: Int): Int {
        if (player.openedInventory is PlayerInventory || player.openedInventory == null) return slot

        val openedInventory = player.openedInventory
        val maxSize = openedInventory.size
        val maxSizeSlotWithPlayerInventory: Int = maxSize + 9 * 4
        val firstSlotHotBar = maxSizeSlotWithPlayerInventory - 9
        if (slot >= firstSlotHotBar) {
            return slot - firstSlotHotBar
        } else {
            return slot - maxSize + 9
        }

    }


    private fun updateItemStack(inventory: Inventory, index: Int) {
        inventory.notify(Player::class.java) { player ->
            val inventory = if (player.openedInventory != null) player.openedInventory else player.inventory
            var slot = index
            var slotItem = PlayerInventory.indexFromAccurateSlot(index)
            if (player.openedInventory != null && player.openedInventory !is PlayerInventory) {
                slot = calculateRealIndex(player, index)
                slotItem = itemSlotFromIndex(player, slot)
            }
            player.minecraftSession.sendItemStack(inventory, slot, player.inventory.getItemStack(slotItem))
        }
    }

}
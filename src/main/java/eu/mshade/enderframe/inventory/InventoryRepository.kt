package eu.mshade.enderframe.inventory

import java.util.UUID

object InventoryRepository {

    private val inventories = mutableMapOf<UUID, Inventory>()

    fun add(inventory: Inventory) {
        inventories[inventory.uniqueId] = inventory
    }

    fun remove(inventory: Inventory) {
        inventories.remove(inventory.uniqueId)
    }

    fun getInventory(uniqueId: UUID): Inventory? {
        return inventories[uniqueId]
    }

    fun getInventory(uniqueId: String): Inventory? {
        return getInventory(UUID.fromString(uniqueId))
    }

    fun getInventories(): Collection<Inventory> {
        return inventories.values
    }

}
package eu.mshade.enderframe.inventory

import eu.mshade.enderframe.item.ItemStack
import eu.mshade.enderframe.mojang.chat.TextComponent
import java.util.*

open class NamedInventory : Inventory {

    val name: TextComponent

    constructor(name: String, inventoryKey: InventoryKey) : super(inventoryKey, UUID.randomUUID()) {
        this.name = TextComponent.of(name)
    }

    constructor(name: TextComponent, inventoryKey: InventoryKey, uniqueId: UUID = UUID.randomUUID()) : super(inventoryKey, uniqueId) {
        this.name = name
    }

    constructor(name: TextComponent, inventoryKey: InventoryKey, vararg itemStack: ItemStack, uuid: UUID) : super(
        inventoryKey,
        itemStack,
        uuid
    ) {
        this.name = name
    }

}
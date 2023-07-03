package eu.mshade.enderframe.inventory

import eu.mshade.enderframe.item.ItemStack
import eu.mshade.enderframe.mojang.chat.TextComponent

open class NamedInventory : Inventory {

    val name: TextComponent

    constructor(name: String, inventoryKey: InventoryKey) : super(inventoryKey) {
        this.name = TextComponent.of(name)
    }

    constructor(name: TextComponent, inventoryKey: InventoryKey) : super(inventoryKey) {
        this.name = name
    }


    constructor(name: TextComponent, inventoryKey: InventoryKey, itemStacks: Array<ItemStack?>) : super(
        inventoryKey,
        itemStacks,
    ) {
        this.name = name
    }

    constructor(name: String, inventoryKey: InventoryKey, itemStacks: Array<ItemStack?>) : super(
        inventoryKey,
        itemStacks,
    ) {
        this.name = TextComponent.of(name)
    }

}
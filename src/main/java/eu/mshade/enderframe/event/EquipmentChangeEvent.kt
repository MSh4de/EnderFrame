package eu.mshade.enderframe.event

import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.inventory.EquipmentSlot
import eu.mshade.enderframe.inventory.Inventory
import eu.mshade.enderframe.item.ItemStack

class EquipmentChangeEvent(
    val entity: Entity,
    val equipmentSlot: EquipmentSlot,
    val oldItemStack: ItemStack?,
    val newItemStack: ItemStack?
) : MinecraftEvent()
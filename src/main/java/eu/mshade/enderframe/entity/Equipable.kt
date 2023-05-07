package eu.mshade.enderframe.entity

import eu.mshade.enderframe.inventory.EquipmentSlot
import eu.mshade.enderframe.item.ItemStack

interface Equipable {

    fun getEquipment(slot: EquipmentSlot): ItemStack?

    fun setEquipment(slot: EquipmentSlot, itemStack: ItemStack?)

    fun getEquipments(): Map<EquipmentSlot, ItemStack>

}
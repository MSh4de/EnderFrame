package eu.mshade.enderframe.event

import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.item.ItemStack

class PlayerArmorEquipEvent(val entity: Entity, val itemStack: ItemStack): MinecraftEvent()
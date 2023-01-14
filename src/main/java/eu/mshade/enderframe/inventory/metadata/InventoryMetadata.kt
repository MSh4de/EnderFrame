package eu.mshade.enderframe.inventory.metadata

import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue

object InventoryMetadataType {
    val ANVIL_REPAIR_COST: MetadataKey = MetadataKey.from("BLOCK_ANVIL_REPAIR_COST")

    val BEACON_POWER_LEVEL: MetadataKey = MetadataKey.from("BLOCK_BEACON_POWER_LEVEL")
    val BEACON_FIRST_POTION_EFFECT: MetadataKey = MetadataKey.from("BLOCK_BEACON_FIRST_POTION_EFFECT")
    val BEACON_SECOND_POTION_EFFECT: MetadataKey = MetadataKey.from("BLOCK_BEACON_SECOND_POTION_EFFECT")

    val BREWING_STAND_BREW_TIME: MetadataKey = MetadataKey.from("BLOCK_BREWING_STAND_BREW_TIME")

    val ENCHANTMENT_TABLE_TOP_SLOT_LEVEL: MetadataKey = MetadataKey.from("BLOCK_ENCHANTMENT_TABLE_TOP_SLOT_LEVEL")
    val ENCHANTMENT_TABLE_MIDDLE_SLOT_LEVEL: MetadataKey = MetadataKey.from("BLOCK_ENCHANTMENT_TABLE_MIDDLE_SLOT_LEVEL")
    val ENCHANTMENT_TABLE_BOTTOM_SLOT_LEVEL: MetadataKey = MetadataKey.from("BLOCK_ENCHANTMENT_TABLE_BOTTOM_SLOT_LEVEL")
    val ENCHANTMENT_TABLE_VIEW_SEED: MetadataKey = MetadataKey.from("BLOCK_ENCHANTMENT_TABLE_VIEW_SEED")
    val ENCHANTMENT_TABLE_TOP_SLOT_ID: MetadataKey = MetadataKey.from("BLOCK_ENCHANTMENT_TABLE_TOP_SLOT_ID")
    val ENCHANTMENT_TABLE_MIDDLE_SLOT_ID: MetadataKey = MetadataKey.from("BLOCK_ENCHANTMENT_TABLE_MIDDLE_SLOT_ID")
    val ENCHANTMENT_TABLE_BOTTOM_SLOT_ID: MetadataKey = MetadataKey.from("BLOCK_ENCHANTMENT_TABLE_BOTTOM_SLOT_ID")
}

class AnvilRepairCostMetadata(cost: Int) : MetadataKeyValue<Int>(InventoryMetadataType.ANVIL_REPAIR_COST, cost)

class BeaconPowerLevelMetadata(powerLevel: Int) : MetadataKeyValue<Int>(InventoryMetadataType.BEACON_POWER_LEVEL, powerLevel)

class BrewingStandBrewTimeMetadata(brewTime: Int) : MetadataKeyValue<Int>(InventoryMetadataType.BREWING_STAND_BREW_TIME, brewTime)

class EnchantmentTableViewSeedMetadata(viewSeed: Int) : MetadataKeyValue<Int>(InventoryMetadataType.ENCHANTMENT_TABLE_VIEW_SEED, viewSeed)


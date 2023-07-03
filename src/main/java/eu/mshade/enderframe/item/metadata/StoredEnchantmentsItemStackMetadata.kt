package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.Enchantment
import eu.mshade.enderframe.item.ItemStackMetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue

class StoredEnchantmentsItemStackMetadata(metadataValue: List<Enchantment>) :
    MetadataKeyValue<List<Enchantment>>(ItemStackMetadataKey.STORED_ENCHANTMENTS, metadataValue)

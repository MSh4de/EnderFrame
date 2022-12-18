package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.PotionEffect
import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey

class PotionNameItemStackMetadata(metadataValue: String) :
    MetadataKeyValue<String>(ItemStackMetadataKey.POTION, metadataValue)

class CustomPotionEffectsItemStackMetadata(metadataValue: List<PotionEffect>) :
    MetadataKeyValue<List<PotionEffect>>(ItemStackMetadataKey.CUSTOM_POTION_EFFECTS, metadataValue)
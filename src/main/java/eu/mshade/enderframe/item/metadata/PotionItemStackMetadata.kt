package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.effect.Effect
import eu.mshade.enderframe.item.ItemStackMetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue

class PotionNameItemStackMetadata(metadataValue: String) :
    MetadataKeyValue<String>(ItemStackMetadataKey.POTION, metadataValue)

class CustomPotionEffectsItemStackMetadata(metadataValue: List<Effect>) :
    MetadataKeyValue<List<Effect>>(ItemStackMetadataKey.CUSTOM_POTION_EFFECTS, metadataValue)
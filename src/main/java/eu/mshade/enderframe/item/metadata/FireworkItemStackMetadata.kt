package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.Firework
import eu.mshade.enderframe.item.FireworkExplosion
import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey

class FireworkExplosionItemStackMetadata(metadataValue: FireworkExplosion) :
    MetadataKeyValue<FireworkExplosion>(ItemStackMetadataKey.EXPLOSION, metadataValue)

class FireworkFireworksItemStackMetadata(metadataValue: Firework) :
    MetadataKeyValue<Firework>(ItemStackMetadataKey.FIREWORKS, metadataValue)
package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.item.ItemStack
import eu.mshade.enderframe.metadata.MetadataKeyValue

class ItemEntityMetadata(itemStack: ItemStack): MetadataKeyValue<ItemStack>(EntityMetadataKey.ITEM, itemStack)
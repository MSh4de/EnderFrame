package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.ItemStackMetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue

class RepairCostItemStackMetadata(metadataValue: Int) :
    MetadataKeyValue<Int>(ItemStackMetadataKey.REPAIR_COST, metadataValue)
package eu.mshade.enderframe.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.mwork.binarytag.BinaryTag

interface MetadataKeyValueBuffer {

    fun read(binaryTag: BinaryTag<*>): MetadataKeyValue<*>

    fun write(metadataKeyValue: MetadataKeyValue<*>) : BinaryTag<*>

}
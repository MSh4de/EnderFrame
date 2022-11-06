package eu.mshade.enderframe.virtualserver

import eu.mshade.enderframe.metadata.MetadataKeyValueBucket
import eu.mshade.enderframe.world.ParentWorldMetadata
import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.WorldMetadataType
import java.io.File

abstract class VirtualWorld(worldDirectory: File, metadataKeyValueBucket: MetadataKeyValueBucket): World(worldDirectory, metadataKeyValueBucket){

    fun getParentWorld(): World {
        return metadataKeyValueBucket.getMetadataKeyValue(WorldMetadataType.PARENT, ParentWorldMetadata::class.java).metadataValue
    }

    fun setParentWorld(world: World) {
        metadataKeyValueBucket.setMetadataKeyValue(ParentWorldMetadata(world))
    }

}

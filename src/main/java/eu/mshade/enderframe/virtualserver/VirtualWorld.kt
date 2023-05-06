package eu.mshade.enderframe.virtualserver

import eu.mshade.enderframe.metadata.MetadataKeyValueBucket
import eu.mshade.enderframe.world.ParentWorldMetadata
import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.WorldMetadataType
import java.io.File

abstract class VirtualWorld(worldDirectory: File, metadataKeyValueBucket: MetadataKeyValueBucket): World(worldDirectory, metadataKeyValueBucket){

    fun getParentWorld(): World {
        return metadatas.getMetadataKeyValue(WorldMetadataType.PARENT).metadataValue as World
    }

    fun setParentWorld(world: World) {
        metadatas.setMetadataKeyValue(ParentWorldMetadata(world))
    }

}

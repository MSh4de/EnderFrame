package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.item.Material
import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket
import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import eu.mshade.enderframe.world.chunk.Section

class Block(private val location: Location, private var material: MaterialKey, private val metadataKeyValueBucket: MetadataKeyValueBucket){

    fun getMaterial(): MaterialKey{
        return this.material
    }

    fun setMaterial(material: MaterialKey){
        this.material = material
    }

    fun getMetadataKeyValueBucket(): MetadataKeyValueBucket{
        return this.metadataKeyValueBucket
    }

    fun getLocation(): Location{
        return this.location
    }


}

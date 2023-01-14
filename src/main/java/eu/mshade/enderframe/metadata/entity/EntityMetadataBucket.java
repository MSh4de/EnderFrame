package eu.mshade.enderframe.metadata.entity;

import eu.mshade.enderframe.entity.Entity;
<<<<<<< HEAD
import eu.mshade.enderframe.entity.metadata.EntityMetadataKey;
=======
import eu.mshade.enderframe.metadata.MetadataKey;
>>>>>>> rework-entities
import eu.mshade.enderframe.metadata.MetadataWrapper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class EntityMetadataBucket {

    private final Map<MetadataKey, MetadataWrapper<?>> entityMetadataBufferByType = new HashMap<>();
    private final Map<MetadataKey, Integer> indexEntityMetadataByType = new HashMap<>();


    public <T extends Entity> void registerEntityMetadata(int index, MetadataWrapper<T> metadataWrapper, MetadataKey... entityMetadataKeys){
        for (MetadataKey metadataKey : entityMetadataKeys) {
            this.entityMetadataBufferByType.put(metadataKey, metadataWrapper);
            this.indexEntityMetadataByType.put(metadataKey, index);
        }
    }

    public int getIndexEntityMetadata(MetadataKey entityMetadataKey){
        return this.indexEntityMetadataByType.get(entityMetadataKey);
    }

    public MetadataWrapper getEntityMetadataWrapper(MetadataKey entityMetadataKey){
        return this.entityMetadataBufferByType.get(entityMetadataKey);
    }

    public Collection<MetadataKey> getEntityMetadataTypes(){
        return this.entityMetadataBufferByType.keySet();
    }
}

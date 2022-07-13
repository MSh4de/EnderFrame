package eu.mshade.enderframe.metadata.entity;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.metadata.MetadataWrapper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class EntityMetadataBucket {

    private final Map<EntityMetadataKey, MetadataWrapper<?>> entityMetadataBufferByType = new HashMap<>();
    private final Map<EntityMetadataKey, Integer> indexEntityMetadataByType = new HashMap<>();


    public <T extends Entity> void registerEntityMetadata(int index, MetadataWrapper<T> metadataWrapper, EntityMetadataKey... entityMetadataKeys){
        for (EntityMetadataKey entityMetadataKey : entityMetadataKeys) {
            this.entityMetadataBufferByType.put(entityMetadataKey, metadataWrapper);
            this.indexEntityMetadataByType.put(entityMetadataKey, index);
        }
    }

    public int getIndexEntityMetadata(EntityMetadataKey entityMetadataKey){
        return this.indexEntityMetadataByType.get(entityMetadataKey);
    }

    public MetadataWrapper getEntityMetadataBuffer(EntityMetadataKey entityMetadataKey){
        return this.entityMetadataBufferByType.get(entityMetadataKey);
    }

    public Collection<EntityMetadataKey> getEntityMetadataTypes(){
        return this.entityMetadataBufferByType.keySet();
    }
}

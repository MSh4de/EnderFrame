package eu.mshade.enderframe.metadata;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class EntityMetadataBucket {

    private Map<EntityMetadataType, EntityMetadataWrapper<?>> entityMetadataBufferByType = new HashMap<>();
    private Map<EntityMetadataType, Integer> indexEntityMetadataByType = new HashMap<>();


    public void registerEntityMetadata(int index, EntityMetadataWrapper<?> entityMetadataWrapper, EntityMetadataType... entityMetadataTypes){
        for (EntityMetadataType entityMetadataType : entityMetadataTypes) {
            this.entityMetadataBufferByType.put(entityMetadataType, entityMetadataWrapper);
            this.indexEntityMetadataByType.put(entityMetadataType, index);
        }
    }

    public int getIndexEntityMetadata(EntityMetadataType entityMetadataType){
        return this.indexEntityMetadataByType.get(entityMetadataType);
    }

    public EntityMetadataWrapper getEntityMetadataBuffer(EntityMetadataType entityMetadataType){
        return this.entityMetadataBufferByType.get(entityMetadataType);
    }

    public Collection<EntityMetadataType> getEntityMetadataTypes(){
        return this.entityMetadataBufferByType.keySet();
    }
}

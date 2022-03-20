package eu.mshade.enderframe.metadata;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class EntityMetadataBucket {

    private Map<EntityMetadataType, EntityMetadataBuffer<?>> entityMetadataBufferByType = new HashMap<>();
    private Map<EntityMetadataType, Integer> indexEntityMetadataByType = new HashMap<>();
    private Map<EntityMetadataType, MetadataType> metadataTypeByEntityMetadataType = new HashMap<>();


    public void registerEntityMetadata(int index,  MetadataType metadataType, EntityMetadataBuffer<?> entityMetadataBuffer, EntityMetadataType... entityMetadataTypes){
        for (EntityMetadataType entityMetadataType : entityMetadataTypes) {
            this.entityMetadataBufferByType.put(entityMetadataType, entityMetadataBuffer);
            this.indexEntityMetadataByType.put(entityMetadataType, index);
            this.metadataTypeByEntityMetadataType.put(entityMetadataType, metadataType);
        }
    }

    public int getIndexEntityMetadata(EntityMetadataType entityMetadataType){
        return this.indexEntityMetadataByType.get(entityMetadataType);
    }

    public EntityMetadataBuffer getEntityMetadataBuffer(EntityMetadataType entityMetadataType){
        return this.entityMetadataBufferByType.get(entityMetadataType);
    }

    public MetadataType getMetadataType(EntityMetadataType entityMetadataType){
        return this.metadataTypeByEntityMetadataType.get(entityMetadataType);
    }

    public Collection<EntityMetadataType> getEntityMetadataTypes(){
        return this.entityMetadataBufferByType.keySet();
    }
}

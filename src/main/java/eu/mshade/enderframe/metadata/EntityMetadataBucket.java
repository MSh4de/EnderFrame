package eu.mshade.enderframe.metadata;


import java.util.*;

public class EntityMetadataBucket {

    private final Map<EntityMetadataType, EntityMetadata<?>> entityMetadataByType = new HashMap<>();


    public <T> EntityMetadata<T> getEntityMetadata(EntityMetadataType entityMetadataType){
        return (EntityMetadata<T>) this.entityMetadataByType.get(entityMetadataType);
    }

    public void setEntityMetadata(EntityMetadata<?> entityMetadata){
        this.entityMetadataByType.put(entityMetadata.getEntityMetadataType(), entityMetadata);
    }

    public boolean hasEntityMetadata(EntityMetadataType entityMetadataType){
        return this.entityMetadataByType.containsKey(entityMetadataType);
    }

    public Collection<EntityMetadata<?>> getEntityMetadata(){
        return this.entityMetadataByType.values();
    }



}

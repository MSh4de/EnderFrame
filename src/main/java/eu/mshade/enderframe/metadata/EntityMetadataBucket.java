package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.entity.metadata.InvisibleEntityMetadata;

import java.util.*;

public class EntityMetadataBucket {

    private final Map<EntityMetadataType, EntityMetadata<?>> entityMetadataByType = new HashMap<>();
    private final Set<EntityMetadataType> supportedEntityMetadataType = new HashSet<>();


    public <T> EntityMetadata<T> getEntityMetadata(EntityMetadataType entityMetadataType){
        return (EntityMetadata<T>) this.entityMetadataByType.get(entityMetadataType);
    }

    public void setEntityMetadata(EntityMetadata<?> entityMetadata){
        if (supportedEntityMetadataType.contains(entityMetadata.getEntityMetadataType())) this.entityMetadataByType.put(entityMetadata.getEntityMetadataType(), entityMetadata);
    }

    public boolean hasEntityMetadata(EntityMetadataType entityMetadataType){
        return this.entityMetadataByType.containsKey(entityMetadataType);
    }

    public void addSupportedEntityMetadataType(EntityMetadataType... entityMetadataTypes){
        this.supportedEntityMetadataType.addAll(List.of(entityMetadataTypes));
    }

    public void removeSupportedEntityMetadataType(EntityMetadataType... entityMetadataTypes){
        this.supportedEntityMetadataType.removeAll(List.of(entityMetadataTypes));
    }

    public boolean isSupportEntityMetadataType(EntityMetadataType entityMetadataType){
        return this.supportedEntityMetadataType.contains(entityMetadataType);
    }

}

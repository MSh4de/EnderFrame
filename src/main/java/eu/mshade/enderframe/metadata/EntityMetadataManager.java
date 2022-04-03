package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public abstract class EntityMetadataManager {

    private Map<EntityType, EntityMetadataBucket> entityMetadataBucketByType = new HashMap<>();
    private final Map<MetadataType, Integer> indexByMetadataType = new HashMap<>();
    private final Map<MetadataType, MetadataBuffer<?>> metadataBufferByType = new HashMap<>();

    public void registerEntityMetadataBucket(EntityType entityType, EntityMetadataBucket entityMetadataBucket){
        this.entityMetadataBucketByType.put(entityType, entityMetadataBucket);
    }

    public EntityMetadataBucket getEntityMetadataBucket(Entity entity){
        return getEntityMetadataBucket(entity.getEntityType());
    }

    public EntityMetadataBucket getEntityMetadataBucket(EntityType entityType){
        return this.entityMetadataBucketByType.get(entityType);
    }

    public void registerMetadataIndex(int index, MetadataType metadataType, MetadataBuffer<?> metadataBuffer) {
        this.indexByMetadataType.put(metadataType, index);
        this.metadataBufferByType.put(metadataType, metadataBuffer);
    }

    public MetadataBuffer<?> getMetadataBuffer(MetadataType metadataType){
        return this.metadataBufferByType.get(metadataType);
    }

    public int getMetadataIndex(MetadataType metadataType){
        return this.indexByMetadataType.get(metadataType);
    }

}

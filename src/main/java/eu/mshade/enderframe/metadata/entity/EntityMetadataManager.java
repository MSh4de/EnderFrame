package eu.mshade.enderframe.metadata.entity;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.EntityKey;
import eu.mshade.enderframe.metadata.MetadataBuffer;
import eu.mshade.enderframe.metadata.MetadataType;

import java.util.HashMap;
import java.util.Map;

public abstract class EntityMetadataManager {

    private Map<EntityKey, EntityMetadataBucket> entityMetadataBucketByType = new HashMap<>();
    private final Map<MetadataType, Integer> indexByMetadataType = new HashMap<>();
    private final Map<MetadataType, MetadataBuffer<?>> metadataBufferByType = new HashMap<>();

    public void registerEntityMetadataBucket(EntityKey entityKey, EntityMetadataBucket entityMetadataBucket){
        this.entityMetadataBucketByType.put(entityKey, entityMetadataBucket);
    }

    public EntityMetadataBucket getEntityMetadataBucket(Entity entity){
        return getEntityMetadataBucket(entity.getEntityKey());
    }

    public EntityMetadataBucket getEntityMetadataBucket(EntityKey entityKey){
        return this.entityMetadataBucketByType.get(entityKey);
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

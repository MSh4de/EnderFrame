package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public abstract class EntityMetadataManager {

    private Map<EntityType, EntityMetadataController> entityMetadataControllerByType = new HashMap<>();
    private final Map<MetadataType, Integer> indexByMetadataType = new HashMap<>();
    private final Map<MetadataType, MetadataBuffer<?>> metadataBufferByType = new HashMap<>();

    public void registerEntityMetadataController(EntityType entityType, EntityMetadataController entityMetadataController){
        this.entityMetadataControllerByType.put(entityType, entityMetadataController);
    }

    public void registerMetadataIndex( int index, MetadataType metadataType, MetadataBuffer<?> metadataBuffer) {
        this.indexByMetadataType.put(metadataType, index);
        this.metadataBufferByType.put(metadataType, metadataBuffer);
    }

    public int getMetadataIndex(MetadataType metadataType){
        return this.indexByMetadataType.get(metadataType);
    }

}

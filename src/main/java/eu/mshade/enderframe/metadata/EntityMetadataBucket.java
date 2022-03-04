package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.entity.metadata.InvisibleEntityMetadata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EntityMetadataBucket {

    private final Map<EntityMetadataType, EntityMetadata<?>> entityMetadataByType = new HashMap<>();
    private final Set<EntityMetadataType> supportedEntityMetadataType = new HashSet<>();
    

    public <T> EntityMetadata<T> getEntityMetadata(EntityMetadataType entityMetadataType){
        return (EntityMetadata<T>) this.entityMetadataByType.get(entityMetadataType);
    }

    public boolean hasEntityMetadata(EntityMetadataType entityMetadataType){
        return this.entityMetadataByType.containsKey(entityMetadataType);
    }

}

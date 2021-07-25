package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class EntityMetadataRepository {
    private final Map<EntityType, MetadataRepository> metadataRepository = new HashMap<>();

    public void registerMetadataRepository(EntityType entityType, MetadataRepository metadataRepo) {
        this.metadataRepository.put(entityType,metadataRepo);
    }

    public MetadataRepository getMetadataRepository(EntityType entityType) {
        return metadataRepository.get(entityType);
    }
}

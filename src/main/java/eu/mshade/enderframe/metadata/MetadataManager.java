package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.entity.EntityType;
import eu.mshade.enderframe.metadata.buffer.MetadataBuffer;
import eu.mshade.enderframe.metadata.buffer.type.MetadataTypeBuffer;
import eu.mshade.enderframe.protocol.ByteMessage;

import java.util.HashMap;
import java.util.Map;

public abstract class MetadataManager {

    private final Map<MetadataType, MetadataTypeBuffer> metadataTypes = new HashMap<>();
    private final Map<EntityType, MetadataBuffer> entityBuffers = new HashMap<>();
    private final MetadataTypeRepository metadataTypeRepository = new MetadataTypeRepository();

    public void registerMetadataTypeBuffer(MetadataType metadataType, MetadataTypeBuffer metadataTypeBuffer){
        this.metadataTypes.put(metadataType,metadataTypeBuffer);
    }

    public void registerEntityBuffer(EntityType entityType, MetadataBuffer metadataBuffer){
        this.entityBuffers.put(entityType,metadataBuffer);
    }

    public MetadataTypeBuffer getMetadataTypeBuffer(MetadataType metadataType){
        return this.metadataTypes.get(metadataType);
    }

    public MetadataBuffer getEntityBuffer(EntityType entityType){
        return this.entityBuffers.get(entityType);
    }

    public MetadataTypeRepository getMetadataTypeRepository(){
        return this.metadataTypeRepository;
    }

    public abstract void write(ByteMessage byteMessage, EntityType entityType, MetadataEntry metadataEntry);

}

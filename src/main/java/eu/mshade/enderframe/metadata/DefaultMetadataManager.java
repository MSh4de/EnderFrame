package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.entity.EntityType;
import eu.mshade.enderframe.metadata.buffer.MetadataBuffer;
import eu.mshade.enderframe.metadata.buffer.PlayerMetadataBuffer;
import eu.mshade.enderframe.metadata.buffer.type.*;
import eu.mshade.enderframe.protocol.ByteMessage;

import java.util.HashMap;
import java.util.Map;

public class DefaultMetadataManager extends MetadataManager {

    private static final Map<MetadataType, MetadataTypeBuffer> metadataTypes = new HashMap<>();
    private static final Map<EntityType, MetadataBuffer> entityBuffers = new HashMap<>();

    static {
        metadataTypes.put(MetadataType.BYTE, new ByteMetadataTypeBuffer());
        metadataTypes.put(MetadataType.BOOLEAN, new BooleanMetadataTypeBuffer());
        metadataTypes.put(MetadataType.FLOAT, new FloatMetadataTypeBuffer());
        metadataTypes.put(MetadataType.OPT_BLOCK_POSITION, new OptBlockPositionMetadataTypeBuffer());
        metadataTypes.put(MetadataType.CHAT, new OptChatMetadataTypeBuffer());
        metadataTypes.put(MetadataType.POSE, new PoseMetadataTypeBuffer());
        metadataTypes.put(MetadataType.VAR_INT, new VarIntMetadataTypeBuffer());
        metadataTypes.put(MetadataType.OPT_CHAT, new OptChatMetadataTypeBuffer());

        entityBuffers.put(EntityType.PLAYER, new PlayerMetadataBuffer());
    }

    @Override
    public MetadataTypeBuffer getMetadataTypeBuffer(MetadataType metadataType) {
        return metadataTypes.get(metadataType);
    }

    @Override
    public MetadataTypeRepository getMetadataTypeRepository() {
        return null;
    }

    @Override
    public void write(ByteMessage byteMessage, EntityType entityType, MetadataEntry metadataEntry) {
        entityBuffers.get(entityType).write(byteMessage, this, metadataEntry);
    }


}

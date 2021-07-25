package eu.mshade.enderframe.metadata.buffer.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.type.OptBlockPositionMetadata;
import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.world.BlockPosition;

public class OptBlockPositionMetadataTypeBuffer implements MetadataTypeBuffer {

    @Override
    public void write(ByteMessage byteMessage, Metadata<?> metadata) {
        byteMessage.writeBoolean(true);
        byteMessage.writeBlockPosition((BlockPosition) metadata.get());
    }
}

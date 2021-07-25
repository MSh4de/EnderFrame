package eu.mshade.enderframe.metadata.buffer.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.type.VarIntMetadata;
import eu.mshade.enderframe.protocol.ByteMessage;

public class VarIntMetadataTypeBuffer implements MetadataTypeBuffer {
    @Override
    public void write(ByteMessage byteMessage, Metadata<?> metadata) {
        byteMessage.writeVarInt((int) metadata.get());
    }
}

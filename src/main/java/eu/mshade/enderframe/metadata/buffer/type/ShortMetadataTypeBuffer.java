package eu.mshade.enderframe.metadata.buffer.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.protocol.ByteMessage;

public class ShortMetadataTypeBuffer implements MetadataTypeBuffer {
    @Override
    public void write(ByteMessage byteMessage, Metadata<?> metadata) {
        byteMessage.writeShort((short) metadata.get());
    }
}

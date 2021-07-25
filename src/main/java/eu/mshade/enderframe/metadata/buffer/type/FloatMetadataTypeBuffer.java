package eu.mshade.enderframe.metadata.buffer.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.type.FloatMetadata;
import eu.mshade.enderframe.protocol.ByteMessage;

public class FloatMetadataTypeBuffer implements MetadataTypeBuffer{

    @Override
    public void write(ByteMessage byteMessage, Metadata<?> metadata) {
        byteMessage.writeFloat((float) metadata.get());
    }
}

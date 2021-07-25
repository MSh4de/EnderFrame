package eu.mshade.enderframe.metadata.buffer.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.type.BooleanMetadata;
import eu.mshade.enderframe.protocol.ByteMessage;

public class BooleanMetadataTypeBuffer implements MetadataTypeBuffer {


    @Override
    public void write(ByteMessage byteMessage, Metadata<?> metadata) {
        byteMessage.writeBoolean((boolean) metadata.get());
    }
}

package eu.mshade.enderframe.metadata.buffer.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.protocol.ByteMessage;

import java.nio.ByteBuffer;

public interface MetadataTypeBuffer {

    void write(ByteMessage byteMessage,  Metadata<?> metadata);

}

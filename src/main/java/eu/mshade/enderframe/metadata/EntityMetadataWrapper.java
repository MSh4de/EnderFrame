package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.protocol.ByteMessage;

public interface EntityMetadataBuffer<T extends Entity> {

    void write(ByteMessage byteMessage, T t);

}

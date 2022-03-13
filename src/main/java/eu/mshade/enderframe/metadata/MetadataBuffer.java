package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.protocol.ByteMessage;

public interface MetadataBuffer<T extends Metadata<?>> {

    void write(ByteMessage byteMessage, T t);

}

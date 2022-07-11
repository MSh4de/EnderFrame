package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.protocol.ProtocolBuffer;

@FunctionalInterface
public interface MetadataBuffer<T extends Metadata<?>> {

    void write(ProtocolBuffer protocolBuffer, T t);

}

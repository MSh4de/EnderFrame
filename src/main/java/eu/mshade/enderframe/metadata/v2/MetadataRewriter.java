package eu.mshade.enderframe.metadata.v2;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.metadata.MetadataType;
import eu.mshade.enderframe.protocol.ByteMessage;

public abstract class MetadataRewriter {

    public abstract void write(MetadataManager metadataManager, ByteMessage byteMessage, Entity entity);
    public abstract MetadataType getMetadataType();
}

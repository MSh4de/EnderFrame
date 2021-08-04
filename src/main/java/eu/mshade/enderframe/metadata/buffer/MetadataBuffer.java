package eu.mshade.enderframe.metadata.buffer;

import eu.mshade.enderframe.metadata.MetadataEntry;
import eu.mshade.enderframe.metadata.MetadataRepository;
import eu.mshade.enderframe.metadata.v2.MetadataManager;
import eu.mshade.enderframe.protocol.ByteMessage;

public abstract class MetadataBuffer {

    private final MetadataRepository metadataRepository = new MetadataRepository();

    public abstract void write(ByteMessage byteMessage, MetadataManager metadataManager, MetadataEntry metadataEntry);

    public MetadataRepository getMetadataRepository() {
        return metadataRepository;
    }
}
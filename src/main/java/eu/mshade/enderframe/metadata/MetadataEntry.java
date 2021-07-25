package eu.mshade.enderframe.metadata;

public class MetadataEntry {

    private final MetadataMeaning metadataMeaning;
    private final Metadata<?> metadata;

    public MetadataEntry(MetadataMeaning metadataMeaning, Metadata<?> metadata) {
        this.metadataMeaning = metadataMeaning;
        this.metadata = metadata;
    }

    public MetadataMeaning getMetadataMeaning() {
        return metadataMeaning;
    }

    public Metadata<?> getMetadata() {
        return metadata;
    }
}

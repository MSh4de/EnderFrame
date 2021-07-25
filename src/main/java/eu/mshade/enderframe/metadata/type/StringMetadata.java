package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;

public class StringMetadata implements Metadata<String> {

    private final String string;

    public StringMetadata(String string) {
        this.string = string;
    }

    @Override
    public String get() {
        return string;
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.STRING;
    }
}

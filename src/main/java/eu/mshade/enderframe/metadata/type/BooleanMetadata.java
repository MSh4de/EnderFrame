package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;

public class BooleanMetadata implements Metadata<Boolean> {

    private final boolean aBoolean;

    public BooleanMetadata(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    @Override
    public Boolean get() {
        return aBoolean;
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.BOOLEAN;
    }
}

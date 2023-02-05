package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;

public class ShortMetadata implements Metadata<Short> {

    private final short aShort;

    public ShortMetadata(short aShort) {
        this.aShort = aShort;
    }

    @Override
    public Short get() {
        return aShort;
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.SHORT;
    }
}

package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;

public class IntegerMetadata implements Metadata<Integer> {

    private final int aInt;

    public IntegerMetadata(int aInt) {
        this.aInt = aInt;
    }

    @Override
    public Integer get() {
        return aInt;
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.INTEGER;
    }
}

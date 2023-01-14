package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;

public class FloatMetadata implements Metadata<Float> {

    private final float aFloat;

    public FloatMetadata(float aFloat) {
        this.aFloat = aFloat;
    }

    @Override
    public Float get() {
        return aFloat;
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.FLOAT;
    }
}

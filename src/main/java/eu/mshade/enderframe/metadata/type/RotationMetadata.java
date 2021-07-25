package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;
import eu.mshade.enderframe.world.Position;
import eu.mshade.enderframe.world.Rotation;

public class RotationMetadata implements Metadata<Rotation> {

    private final Rotation rotation;

    public RotationMetadata(Rotation rotation) {
        this.rotation = rotation;
    }


    @Override
    public Rotation get() {
        return rotation;
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.ROTATION;
    }
}

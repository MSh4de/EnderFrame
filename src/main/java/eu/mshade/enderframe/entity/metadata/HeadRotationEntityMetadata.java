package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;
import eu.mshade.enderframe.world.Rotation;

public class HeadRotationEntityMetadata extends EntityMetadata<Rotation> {

    public HeadRotationEntityMetadata(Rotation rotation) {
        super(rotation, EntityMetadataType.HEAD_ROTATION);
    }

}

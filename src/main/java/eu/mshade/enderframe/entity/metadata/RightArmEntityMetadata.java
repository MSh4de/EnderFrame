package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;
import eu.mshade.enderframe.world.Rotation;

public class RightArmEntityMetadata extends EntityMetadata<Rotation> {

    public RightArmEntityMetadata(Rotation rotation) {
        super(rotation, EntityMetadataType.RIGHT_ARM_ROTATION);
    }

}

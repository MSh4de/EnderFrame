package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;
import eu.mshade.enderframe.world.Rotation;

public class LeftArmRotationEntityMetadata extends EntityMetadata<Rotation> {

    public LeftArmRotationEntityMetadata(Rotation rotation) {
        super(rotation, EntityMetadataType.LEFT_ARM_ROTATION);
    }

}

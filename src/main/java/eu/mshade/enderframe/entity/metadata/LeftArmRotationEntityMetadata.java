package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;
import eu.mshade.enderframe.world.Rotation;

public class LeftArmRotationEntityMetadata extends EntityMetadataKeyValue<Rotation> {

    public LeftArmRotationEntityMetadata(Rotation rotation) {
        super(EntityMetadataKey.LEFT_ARM_ROTATION, rotation);
    }

}

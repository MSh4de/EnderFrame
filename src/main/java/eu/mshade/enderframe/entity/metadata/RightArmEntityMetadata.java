package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;
import eu.mshade.enderframe.world.Rotation;

public class RightArmEntityMetadata extends EntityMetadataKeyValue<Rotation> {

    public RightArmEntityMetadata(Rotation rotation) {
        super(EntityMetadataKey.RIGHT_ARM_ROTATION, rotation);
    }

}

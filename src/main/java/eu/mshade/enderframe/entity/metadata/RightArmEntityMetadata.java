package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.world.Rotation;

public class RightArmEntityMetadata extends MetadataKeyValue<Rotation> {

    public RightArmEntityMetadata(Rotation rotation) {
        super(EntityMetadataKey.RIGHT_ARM_ROTATION, rotation);
    }

}

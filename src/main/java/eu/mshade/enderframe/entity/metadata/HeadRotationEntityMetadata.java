package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;
import eu.mshade.enderframe.world.Rotation;

public class HeadRotationEntityMetadata extends EntityMetadataKeyValue<Rotation> {

    public HeadRotationEntityMetadata(Rotation rotation) {
        super(EntityMetadataKey.HEAD_ROTATION, rotation);
    }

}

package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.world.Rotation;

public class HeadRotationEntityMetadata extends MetadataKeyValue<Rotation> {

    public HeadRotationEntityMetadata(Rotation rotation) {
        super(EntityMetadataKey.HEAD_ROTATION, rotation);
    }

}

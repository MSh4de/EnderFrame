package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;
import eu.mshade.enderframe.world.Rotation;

public class LeftLegEntityMetadata extends EntityMetadataKeyValue<Rotation> {

    public LeftLegEntityMetadata(Rotation rotation) {
        super(EntityMetadataKey.LEFT_LEG_ROTATION, rotation);
    }

}

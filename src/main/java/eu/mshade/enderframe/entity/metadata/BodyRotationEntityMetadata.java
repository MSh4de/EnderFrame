package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;
import eu.mshade.enderframe.world.Rotation;

public class BodyRotationEntityMetadata extends EntityMetadataKeyValue<Rotation> {

    public BodyRotationEntityMetadata(Rotation rotation) {
        super(EntityMetadataKey.BODY_ROTATION, rotation);
    }

}

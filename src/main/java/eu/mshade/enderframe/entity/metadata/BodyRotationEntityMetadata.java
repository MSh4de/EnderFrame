package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.world.Rotation;

public class BodyRotationEntityMetadata extends MetadataKeyValue<Rotation> {

    public BodyRotationEntityMetadata(Rotation rotation) {
        super(EntityMetadataKey.BODY_ROTATION, rotation);
    }

}

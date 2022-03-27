package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;
import eu.mshade.enderframe.world.Rotation;

public class BodyRotationEntityMetadata extends EntityMetadata<Rotation> {

    public BodyRotationEntityMetadata(Rotation rotation) {
        super(rotation, EntityMetadataType.BODY_ROTATION);
    }

}

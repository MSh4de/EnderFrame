package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;
import eu.mshade.enderframe.world.Rotation;

public class LeftLegEntityMetadata extends EntityMetadata<Rotation> {

    public LeftLegEntityMetadata(Rotation rotation) {
        super(rotation, EntityMetadataType.LEFT_LEG_ROTATION);
    }

}

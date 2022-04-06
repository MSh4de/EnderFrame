package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class GravityEntityMetadata extends EntityMetadata<Boolean> {

    public static GravityEntityMetadata DEFAULT = new GravityEntityMetadata(false);

    public GravityEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.GRAVITY);
    }

}

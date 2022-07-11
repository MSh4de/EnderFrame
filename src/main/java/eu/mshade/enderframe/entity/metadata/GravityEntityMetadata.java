package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class GravityEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public static GravityEntityMetadata DEFAULT = new GravityEntityMetadata(false);

    public GravityEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.GRAVITY, aBoolean);
    }

}

package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class GravityEntityMetadata extends MetadataKeyValue<Boolean> {

    public static GravityEntityMetadata DEFAULT = new GravityEntityMetadata(false);

    public GravityEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.GRAVITY, aBoolean);
    }

}

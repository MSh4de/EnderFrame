package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class OnFireEntityMetadata extends MetadataKeyValue<Boolean> {

    public static OnFireEntityMetadata DEFAULT = new OnFireEntityMetadata(false);

    public OnFireEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.ON_FIRE, aBoolean);
    }

}

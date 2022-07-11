package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class OnFireEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public static OnFireEntityMetadata DEFAULT = new OnFireEntityMetadata(false);

    public OnFireEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.ON_FIRE, aBoolean);
    }

}

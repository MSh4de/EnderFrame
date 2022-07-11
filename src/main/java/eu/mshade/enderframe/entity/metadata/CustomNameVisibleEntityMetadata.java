package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class CustomNameVisibleEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public CustomNameVisibleEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.CUSTOM_NAME_VISIBLE, aBoolean);
    }

}

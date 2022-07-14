package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class CustomNameVisibleEntityMetadata extends MetadataKeyValue<Boolean> {

    public CustomNameVisibleEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.CUSTOM_NAME_VISIBLE, aBoolean);
    }

}

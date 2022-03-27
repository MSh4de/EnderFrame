package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class CustomNameVisibleEntityMetadata extends EntityMetadata<Boolean> {

    public CustomNameVisibleEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.CUSTOM_NAME_VISIBLE);
    }

}

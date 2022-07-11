package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class CustomNameEntityMetadata extends EntityMetadataKeyValue<String> {

    public CustomNameEntityMetadata(String s) {
        super(EntityMetadataKey.CUSTOM_NAME, s);
    }

}

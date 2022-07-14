package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class CustomNameEntityMetadata extends MetadataKeyValue<String> {

    public CustomNameEntityMetadata(String s) {
        super(EntityMetadataKey.CUSTOM_NAME, s);
    }

}

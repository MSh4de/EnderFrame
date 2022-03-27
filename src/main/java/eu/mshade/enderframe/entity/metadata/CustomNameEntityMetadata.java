package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class CustomNameEntityMetadata extends EntityMetadata<String> {

    public CustomNameEntityMetadata(String s) {
        super(s, EntityMetadataType.CUSTOM_NAME);
    }

}

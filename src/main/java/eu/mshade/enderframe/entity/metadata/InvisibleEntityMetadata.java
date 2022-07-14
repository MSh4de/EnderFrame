package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class InvisibleEntityMetadata extends MetadataKeyValue<Boolean> {

    public static InvisibleEntityMetadata DEFAULT = new InvisibleEntityMetadata(false);

    public InvisibleEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.INVISIBLE, aBoolean);
    }

}

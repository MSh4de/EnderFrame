package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class InvisibleEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public static InvisibleEntityMetadata DEFAULT = new InvisibleEntityMetadata(false);

    public InvisibleEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.INVISIBLE, aBoolean);
    }

}

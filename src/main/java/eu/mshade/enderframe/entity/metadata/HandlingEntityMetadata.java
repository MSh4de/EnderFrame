package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class HandlingEntityMetadata extends MetadataKeyValue<Boolean> {

    public static HandlingEntityMetadata DEFAULT = new HandlingEntityMetadata(false);

    public HandlingEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.HANDLING, aBoolean);
    }

}

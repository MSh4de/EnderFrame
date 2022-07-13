package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class HandlingEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public static HandlingEntityMetadata DEFAULT = new HandlingEntityMetadata(false);

    public HandlingEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.HANDLING, aBoolean);
    }

}

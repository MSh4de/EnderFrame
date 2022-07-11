package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class AllowFlyingEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public AllowFlyingEntityMetadata(Boolean metadataValue) {
        super(EntityMetadataKey.ALLOW_FLYING, metadataValue);
    }
}

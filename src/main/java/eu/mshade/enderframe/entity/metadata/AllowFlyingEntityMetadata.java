package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class AllowFlyingEntityMetadata extends MetadataKeyValue<Boolean> {

    public AllowFlyingEntityMetadata(Boolean metadataValue) {
        super(EntityMetadataKey.ALLOW_FLYING, metadataValue);
    }
}

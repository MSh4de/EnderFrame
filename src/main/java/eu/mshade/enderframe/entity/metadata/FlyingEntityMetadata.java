package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class FlyingEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public final static FlyingEntityMetadata DEFAULT = new FlyingEntityMetadata(false);

    public FlyingEntityMetadata(Boolean metadataValue) {
        super(EntityMetadataKey.FLYING, metadataValue);
    }
}

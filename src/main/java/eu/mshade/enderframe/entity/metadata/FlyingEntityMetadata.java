package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class FlyingEntityMetadata extends MetadataKeyValue<Boolean> {

    public final static FlyingEntityMetadata DEFAULT = new FlyingEntityMetadata(false);

    public FlyingEntityMetadata(Boolean metadataValue) {
        super(EntityMetadataKey.FLYING, metadataValue);
    }
}

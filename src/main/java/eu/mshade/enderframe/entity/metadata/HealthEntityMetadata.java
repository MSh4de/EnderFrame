package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class HealthEntityMetadata extends MetadataKeyValue<Float> {

    public HealthEntityMetadata(Float aFloat) {
        super(EntityMetadataKey.HEALTH, aFloat);
    }

}

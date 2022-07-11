package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class HealthEntityMetadata extends EntityMetadataKeyValue<Float> {

    public HealthEntityMetadata(Float aFloat) {
        super(EntityMetadataKey.HEALTH, aFloat);
    }

}

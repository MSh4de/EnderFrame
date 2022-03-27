package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class HealthEntityMetadata extends EntityMetadata<Float> {

    public HealthEntityMetadata(Float aFloat) {
        super(aFloat, EntityMetadataType.HEALTH);
    }

}

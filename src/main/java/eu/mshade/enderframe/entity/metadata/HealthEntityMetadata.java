package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class HealthEntityMetadata implements EntityMetadata<Float> {

    private float health;

    @Override
    public void set(Float aFloat) {
        this.health = aFloat;
    }

    @Override
    public Float get() {
        return this.health;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.HEALTH;
    }
}

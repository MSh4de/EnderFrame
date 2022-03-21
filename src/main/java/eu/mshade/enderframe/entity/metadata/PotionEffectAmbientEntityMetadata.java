package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class PotionEffectAmbientEntityMetadata implements EntityMetadata<Boolean> {

    private boolean potionEffectAmbient;

    @Override
    public void set(Boolean aBoolean) {
        this.potionEffectAmbient = aBoolean;
    }

    @Override
    public Boolean get() {
        return this.potionEffectAmbient;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.POTION_EFFECT_AMBIENT;
    }
}

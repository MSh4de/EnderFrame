package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class PotionEffectColorEntityMetadata implements EntityMetadata<Integer> {

    private int potionEffectColor;

    @Override
    public void set(Integer integer) {
        this.potionEffectColor = integer;
    }

    @Override
    public Integer get() {
        return this.potionEffectColor;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.POTION_EFFECT_COLOR;
    }
}

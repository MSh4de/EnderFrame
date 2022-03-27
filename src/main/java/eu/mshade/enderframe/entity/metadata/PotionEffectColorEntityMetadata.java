package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class PotionEffectColorEntityMetadata extends EntityMetadata<Integer> {

    public PotionEffectColorEntityMetadata(Integer integer) {
        super(integer, EntityMetadataType.POTION_EFFECT_COLOR);
    }

}

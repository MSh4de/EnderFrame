package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class PotionEffectColorEntityMetadata extends EntityMetadataKeyValue<Integer> {

    public PotionEffectColorEntityMetadata(Integer integer) {
        super(EntityMetadataKey.POTION_EFFECT_COLOR, integer);
    }

}

package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class PotionEffectColorEntityMetadata extends MetadataKeyValue<Integer> {

    public PotionEffectColorEntityMetadata(Integer integer) {
        super(EntityMetadataKey.POTION_EFFECT_COLOR, integer);
    }

}

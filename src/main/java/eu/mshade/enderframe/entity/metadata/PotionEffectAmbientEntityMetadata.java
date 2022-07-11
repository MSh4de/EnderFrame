package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class PotionEffectAmbientEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public PotionEffectAmbientEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.POTION_EFFECT_AMBIENT, aBoolean);
    }

}

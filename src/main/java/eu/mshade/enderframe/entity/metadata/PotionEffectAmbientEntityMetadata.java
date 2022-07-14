package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class PotionEffectAmbientEntityMetadata extends MetadataKeyValue<Boolean> {

    public PotionEffectAmbientEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.POTION_EFFECT_AMBIENT, aBoolean);
    }

}

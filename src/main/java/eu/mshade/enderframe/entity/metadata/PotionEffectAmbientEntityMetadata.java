package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class PotionEffectAmbientEntityMetadata extends EntityMetadata<Boolean> {

    public PotionEffectAmbientEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.POTION_EFFECT_AMBIENT);
    }

}

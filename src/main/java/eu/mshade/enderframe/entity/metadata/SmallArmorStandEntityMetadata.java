package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class SmallArmorStandEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public static SmallArmorStandEntityMetadata DEFAULT = new SmallArmorStandEntityMetadata(false);

    public SmallArmorStandEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.SMALL_ARMOR_STAND, aBoolean);
    }

}
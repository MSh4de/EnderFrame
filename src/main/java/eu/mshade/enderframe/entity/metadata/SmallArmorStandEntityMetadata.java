package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class SmallArmorStandEntityMetadata extends MetadataKeyValue<Boolean> {

    public static SmallArmorStandEntityMetadata DEFAULT = new SmallArmorStandEntityMetadata(false);

    public SmallArmorStandEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.SMALL_ARMOR_STAND, aBoolean);
    }

}

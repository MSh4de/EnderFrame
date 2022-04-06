package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class SmallArmorStandEntityMetadata extends EntityMetadata<Boolean> {

    public static SmallArmorStandEntityMetadata DEFAULT = new SmallArmorStandEntityMetadata(false);

    public SmallArmorStandEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.SMALL_ARMOR_STAND);
    }

}

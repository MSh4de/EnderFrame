package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class BasePlateEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public static BasePlateEntityMetadata DEFAULT = new BasePlateEntityMetadata(false);

    public BasePlateEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.BASE_PLATE, aBoolean);
    }

}

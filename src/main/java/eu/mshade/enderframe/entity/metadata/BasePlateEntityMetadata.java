package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class BasePlateEntityMetadata extends MetadataKeyValue<Boolean> {

    public static BasePlateEntityMetadata DEFAULT = new BasePlateEntityMetadata(false);

    public BasePlateEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.BASE_PLATE, aBoolean);
    }

}

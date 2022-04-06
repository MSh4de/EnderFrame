package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class BasePlateEntityMetadata extends EntityMetadata<Boolean> {

    public static BasePlateEntityMetadata DEFAULT = new BasePlateEntityMetadata(false);

    public BasePlateEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.BASE_PLATE);
    }

}

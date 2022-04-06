package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class ArmsEntityMetadata extends EntityMetadata<Boolean> {

    public static ArmsEntityMetadata DEFAULT = new ArmsEntityMetadata(false);

    public ArmsEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.ARMS);
    }

}

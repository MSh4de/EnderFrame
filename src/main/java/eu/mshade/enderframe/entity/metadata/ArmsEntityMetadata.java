package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class ArmsEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public static ArmsEntityMetadata DEFAULT = new ArmsEntityMetadata(false);

    public ArmsEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.ARMS, aBoolean);
    }

}

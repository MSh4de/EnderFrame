package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class ArmsEntityMetadata extends MetadataKeyValue<Boolean> {

    public static ArmsEntityMetadata DEFAULT = new ArmsEntityMetadata(false);

    public ArmsEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.ARMS, aBoolean);
    }

}

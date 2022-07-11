package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class MarkerEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public static MarkerEntityMetadata DEFAULT = new MarkerEntityMetadata(false);

    public MarkerEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.MARKER, aBoolean);
    }

}

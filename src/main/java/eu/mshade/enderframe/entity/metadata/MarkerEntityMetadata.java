package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class MarkerEntityMetadata extends MetadataKeyValue<Boolean> {

    public static MarkerEntityMetadata DEFAULT = new MarkerEntityMetadata(false);

    public MarkerEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.MARKER, aBoolean);
    }

}

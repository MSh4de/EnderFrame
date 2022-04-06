package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class MarkerEntityMetadata extends EntityMetadata<Boolean> {

    public static MarkerEntityMetadata DEFAULT = new MarkerEntityMetadata(false);

    public MarkerEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.MARKER);
    }

}

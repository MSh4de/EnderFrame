package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class HandlingEntityMetadata extends EntityMetadata<Boolean> {

    public static HandlingEntityMetadata DEFAULT = new HandlingEntityMetadata(false);

    public HandlingEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.HANDLING);
    }

}

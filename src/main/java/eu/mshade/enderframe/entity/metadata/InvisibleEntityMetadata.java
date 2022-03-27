package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class InvisibleEntityMetadata extends EntityMetadata<Boolean> {

    public static InvisibleEntityMetadata DEFAULT = new InvisibleEntityMetadata(false);

    public InvisibleEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.INVISIBLE);
    }

}

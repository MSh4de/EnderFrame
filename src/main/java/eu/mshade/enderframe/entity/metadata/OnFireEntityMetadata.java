package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class OnFireEntityMetadata extends EntityMetadata<Boolean> {

    public static OnFireEntityMetadata DEFAULT = new OnFireEntityMetadata(false);

    public OnFireEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.ON_FIRE);
    }

}

package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class CrouchedEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public static CrouchedEntityMetadata DEFAULT = new CrouchedEntityMetadata(false);

    public CrouchedEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.CROUCHED, aBoolean);
    }

}

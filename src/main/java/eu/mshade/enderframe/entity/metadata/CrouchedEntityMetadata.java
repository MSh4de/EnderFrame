package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class CrouchedEntityMetadata extends MetadataKeyValue<Boolean> {

    public static CrouchedEntityMetadata DEFAULT = new CrouchedEntityMetadata(false);

    public CrouchedEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.CROUCHED, aBoolean);
    }

}

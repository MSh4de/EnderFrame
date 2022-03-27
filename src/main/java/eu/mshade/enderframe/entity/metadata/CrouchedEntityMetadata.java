package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class CrouchedEntityMetadata extends EntityMetadata<Boolean> {

    public static CrouchedEntityMetadata DEFAULT = new CrouchedEntityMetadata(false);

    public CrouchedEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.CROUCHED);
    }

}

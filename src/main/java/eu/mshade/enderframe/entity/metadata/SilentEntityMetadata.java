package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class SilentEntityMetadata extends EntityMetadata<Boolean> {

    public SilentEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.SILENT);
    }

}

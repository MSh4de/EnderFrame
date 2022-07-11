package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class SilentEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public SilentEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.SILENT, aBoolean);
    }

}

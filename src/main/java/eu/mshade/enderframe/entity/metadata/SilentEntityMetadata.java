package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class SilentEntityMetadata extends MetadataKeyValue<Boolean> {

    public SilentEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.SILENT, aBoolean);
    }

}

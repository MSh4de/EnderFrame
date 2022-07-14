package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class ChildEntityMetadata extends MetadataKeyValue<Boolean> {

    public ChildEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.CHILD, aBoolean);
    }

}

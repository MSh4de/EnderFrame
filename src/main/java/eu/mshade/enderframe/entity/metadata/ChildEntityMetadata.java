package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class ChildEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public ChildEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.CHILD, aBoolean);
    }

}

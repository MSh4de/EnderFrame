package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class ChildEntityMetadata extends EntityMetadata<Boolean> {

    public ChildEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.CHILD);
    }

}

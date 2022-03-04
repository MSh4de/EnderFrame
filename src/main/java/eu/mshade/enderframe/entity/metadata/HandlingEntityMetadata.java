package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class HandlingEntityMetadata implements EntityMetadata<Boolean> {

    private boolean handling = false;

    @Override
    public void set(Boolean aBoolean) {
        this.handling = aBoolean;
    }

    @Override
    public Boolean get() {
        return this.handling;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.HANDLING;
    }
}

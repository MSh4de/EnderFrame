package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class CrouchedEntityMetadata implements EntityMetadata<Boolean> {

    private boolean crouched = false;

    @Override
    public void set(Boolean aBoolean) {
        this.crouched = aBoolean;
    }

    @Override
    public Boolean get() {
        return this.crouched;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.CROUCHED;
    }
}

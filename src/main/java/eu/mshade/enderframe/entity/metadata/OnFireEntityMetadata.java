package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class OnFireEntityMetadata implements EntityMetadata<Boolean> {

    private boolean fire = false;

    @Override
    public void set(Boolean aBoolean) {
        this.fire = aBoolean;
    }

    @Override
    public Boolean get() {
        return fire;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.ON_FIRE;
    }
}

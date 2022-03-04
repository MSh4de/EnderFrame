package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class InvisibleEntityMetadata implements EntityMetadata<Boolean> {

    private boolean invisible = false;

    @Override
    public void set(Boolean aBoolean) {
        this.invisible = aBoolean;
    }

    @Override
    public Boolean get() {
        return this.invisible;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.INVISIBLE;
    }
}

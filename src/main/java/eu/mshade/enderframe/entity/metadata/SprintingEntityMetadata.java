package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class SprintingEntityMetadata implements EntityMetadata<Boolean> {

    private boolean sprinting = false;

    @Override
    public void set(Boolean aBoolean) {
        this.sprinting = aBoolean;
    }

    @Override
    public Boolean get() {
        return this.sprinting;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.SPRINTING;
    }
}

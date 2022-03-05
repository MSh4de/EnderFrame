package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class CustomNameVisibleEntityMetadata implements EntityMetadata<Boolean> {

    private boolean customNameVisible;

    @Override
    public void set(Boolean aBoolean) {
        this.customNameVisible = aBoolean;
    }

    @Override
    public Boolean get() {
        return customNameVisible;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.IS_CUSTOM_NAME_VISIBLE;
    }
}

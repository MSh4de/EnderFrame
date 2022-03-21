package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class SilentEntityMetadata implements EntityMetadata<Boolean> {

    private boolean silent;

    @Override
    public void set(Boolean aBoolean) {
        this.silent = aBoolean;
    }

    @Override
    public Boolean get() {
        return silent;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.SILENT;
    }
}

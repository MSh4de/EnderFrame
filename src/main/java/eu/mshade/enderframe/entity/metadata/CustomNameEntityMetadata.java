package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class CustomNameEntityMetadata implements EntityMetadata<String> {

    private String customName;

    @Override
    public void set(String s) {
        this.customName = s;
    }

    @Override
    public String get() {
        return this.customName;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.CUSTOM_NAME;
    }
}

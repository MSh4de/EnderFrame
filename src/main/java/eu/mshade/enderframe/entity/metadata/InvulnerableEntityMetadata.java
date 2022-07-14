package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class InvulnerableEntityMetadata extends MetadataKeyValue<Boolean> {

    public InvulnerableEntityMetadata(Boolean metadataValue) {
        super(EntityMetadataKey.INVULNERABLE, metadataValue);
    }
}

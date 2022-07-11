package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class InvulnerableEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public InvulnerableEntityMetadata(Boolean metadataValue) {
        super(EntityMetadataKey.INVULNERABLE, metadataValue);
    }
}

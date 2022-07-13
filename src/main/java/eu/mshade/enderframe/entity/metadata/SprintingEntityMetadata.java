package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class SprintingEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public static SprintingEntityMetadata DEFAULT = new SprintingEntityMetadata(false);

    public SprintingEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.SPRINTING, aBoolean);
    }

    @Override
    public String toString() {
        return "SprintingEntityMetadata{" +
                "metadataKey=" + metadataKey +
                ", metadataValue=" + metadataValue +
                '}';
    }
}

package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class SprintingEntityMetadata extends MetadataKeyValue<Boolean> {

    public static SprintingEntityMetadata DEFAULT = new SprintingEntityMetadata(false);

    public SprintingEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.SPRINTING, aBoolean);
    }

}

package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class SprintingEntityMetadata extends EntityMetadata<Boolean> {

    public static SprintingEntityMetadata DEFAULT = new SprintingEntityMetadata(false);

    public SprintingEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.SPRINTING);
    }

}

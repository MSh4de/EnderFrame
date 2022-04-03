package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;
import eu.mshade.enderframe.mojang.SkinPart;

public class SkinPartEntityMetadata extends EntityMetadata<SkinPart> {

    public SkinPartEntityMetadata(SkinPart skinPart) {
        super(skinPart, EntityMetadataType.SKIN_PART);
    }

}

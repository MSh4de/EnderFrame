package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.mojang.SkinPart;

public class SkinPartEntityMetadata extends MetadataKeyValue<SkinPart> {

    public SkinPartEntityMetadata(SkinPart skinPart) {
        super(EntityMetadataKey.SKIN_PART, skinPart);
    }

}

package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.mojang.Color;

public class ColorItemStackMetadata extends MetadataKeyValue<Color> {

    public ColorItemStackMetadata(Color metadataValue) {
        super(ItemStackMetadataKey.COLOR, metadataValue);
    }



}

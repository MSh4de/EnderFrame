package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKeyValue;
import eu.mshade.enderframe.mojang.Color;

public class ColorItemStackMetadata extends ItemStackMetadataKeyValue<Color> {

    public ColorItemStackMetadata(Color metadataValue) {
        super(ItemStackMetadataKey.COLOR, metadataValue);
    }

}

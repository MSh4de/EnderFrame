package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.item.ItemStackMetadataKey;
import eu.mshade.enderframe.mojang.chat.TextComponent;

import java.util.List;

public class LoreItemStackMetadata extends MetadataKeyValue<List<TextComponent>> {

    public LoreItemStackMetadata(List<TextComponent> metadataValue) {
        super(ItemStackMetadataKey.LORE, metadataValue);
    }

}

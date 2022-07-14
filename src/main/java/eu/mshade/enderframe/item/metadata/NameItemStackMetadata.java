package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.mojang.chat.TextComponent;

public class NameItemStackMetadata extends MetadataKeyValue<TextComponent> {

    public NameItemStackMetadata(TextComponent metadataValue) {
        super(ItemStackMetadataKey.NAME, metadataValue);
    }

    public NameItemStackMetadata(String name) {
        this(TextComponent.of(name));
    }

}

package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;
import eu.mshade.enderframe.mojang.chat.TextComponent;

public class OptChatMetadata implements Metadata<TextComponent> {

    private final TextComponent textComponent;

    public OptChatMetadata(TextComponent textComponent) {
        this.textComponent = textComponent;
    }

    @Override
    public TextComponent get() {
        return textComponent;
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.OPT_CHAT;
    }
}

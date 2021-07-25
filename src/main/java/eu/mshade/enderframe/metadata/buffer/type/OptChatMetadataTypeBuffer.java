package eu.mshade.enderframe.metadata.buffer.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.protocol.ByteMessage;

public class OptChatMetadataTypeBuffer implements MetadataTypeBuffer {

    @Override
    public void write(ByteMessage byteMessage, Metadata<?> metadata) {
        byteMessage.writeBoolean(true);
        byteMessage.writeTextComponent((TextComponent) metadata.get());
    }
}

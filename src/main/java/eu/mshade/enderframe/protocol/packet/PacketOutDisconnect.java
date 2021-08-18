package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketOut;

public class PacketOutDisconnect extends PacketOut {

    private TextComponent textComponent;

    public PacketOutDisconnect(TextComponent textComponent) {
        this.textComponent = textComponent;
    }

    @Override
    public void serialize(ByteMessage byteMessage) {
        byteMessage.writeValueAsString(textComponent);
    }
}

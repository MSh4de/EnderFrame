package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.protocol.PacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class PacketOutDisconnect implements PacketOut {

    private TextComponent textComponent;

    public PacketOutDisconnect(TextComponent textComponent) {
        this.textComponent = textComponent;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeValueAsString(textComponent);
    }
}

package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class MinecraftPacketOutDisconnect implements MinecraftPacketOut {

    private TextComponent textComponent;

    public MinecraftPacketOutDisconnect(TextComponent textComponent) {
        this.textComponent = textComponent;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeValueAsString(textComponent);
    }
}

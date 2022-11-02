package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class MinecraftPacketOutPlayerList implements MinecraftPacketOut {

    private TextComponent header, footer;

    public MinecraftPacketOutPlayerList(TextComponent header, TextComponent footer) {
        this.header = header;
        this.footer = footer;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeValueAsString(header);
        protocolBuffer.writeValueAsString(footer);
    }
}

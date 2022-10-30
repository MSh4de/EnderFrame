package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.protocol.PacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class PacketOutPlayerList implements PacketOut {

    private TextComponent header, footer;

    public PacketOutPlayerList(TextComponent header, TextComponent footer) {
        this.header = header;
        this.footer = footer;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeValueAsString(header);
        protocolBuffer.writeValueAsString(footer);
    }
}

package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketOut;

public class PacketOutPlayerList extends PacketOut {

    private String header, footer;

    public PacketOutPlayerList(String header, String footer) {
        this.header = header;
        this.footer = footer;
    }

    @Override
    public void serialize(ByteMessage byteMessage) {
        byteMessage.writeValueAsString(TextComponent.of(header));
        byteMessage.writeValueAsString(TextComponent.of(footer));
    }
}

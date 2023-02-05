package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.MinecraftByteBuf;

public class MinecraftPacketOutPlayerList implements MinecraftPacketOut {

    private TextComponent header, footer;

    public MinecraftPacketOutPlayerList(TextComponent header, TextComponent footer) {
        this.header = header;
        this.footer = footer;
    }

    @Override
    public void serialize(MinecraftByteBuf minecraftByteBuf) {
        minecraftByteBuf.writeValueAsString(header);
        minecraftByteBuf.writeValueAsString(footer);
    }
}

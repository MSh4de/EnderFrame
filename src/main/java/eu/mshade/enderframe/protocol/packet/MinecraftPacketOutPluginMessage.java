package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.MinecraftByteBuf;

import java.util.function.Consumer;

public class MinecraftPacketOutPluginMessage implements MinecraftPacketOut {

    private String channel;
    private Consumer<MinecraftByteBuf> payload;

    public MinecraftPacketOutPluginMessage(String channel, Consumer<MinecraftByteBuf> payload) {
        this.channel = channel;
        this.payload = payload;
    }

    @Override
    public void serialize(MinecraftByteBuf minecraftByteBuf) {
        minecraftByteBuf.writeString(channel);
        payload.accept(minecraftByteBuf);
    }
}

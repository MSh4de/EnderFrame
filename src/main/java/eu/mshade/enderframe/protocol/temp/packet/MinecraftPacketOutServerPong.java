package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.MinecraftByteBuf;

public class MinecraftPacketOutServerPong implements MinecraftPacketOut {

    private final long payload;

    public MinecraftPacketOutServerPong(long payload) {
        this.payload = payload;
    }

    @Override
    public void serialize(MinecraftByteBuf minecraftByteBuf) {
        minecraftByteBuf.writeLong(payload);
    }
}

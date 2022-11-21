package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.MinecraftByteBuf;

public class MinecraftPacketOutPong implements MinecraftPacketOut {

    private final long payload;

    public MinecraftPacketOutPong(long payload) {
        this.payload = payload;
    }

    @Override
    public void serialize(MinecraftByteBuf minecraftByteBuf) {
        minecraftByteBuf.writeLong(payload);
    }
}

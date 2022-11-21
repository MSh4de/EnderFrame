package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.MinecraftByteBuf;

public class MinecraftPacketOutSetCompression implements MinecraftPacketOut {

    private int threshold;

    public MinecraftPacketOutSetCompression(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void serialize(MinecraftByteBuf minecraftByteBuf) {
        minecraftByteBuf.writeVarInt(threshold);
    }
}

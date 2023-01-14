package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketIn;
import eu.mshade.enderframe.protocol.MinecraftByteBuf;
import eu.mshade.enderframe.protocol.MinecraftSession;

public class MinecraftPacketInServerPing implements MinecraftPacketIn {

    private long payload;
    private MinecraftSession minecraftSession;

    @Override
    public void deserialize(MinecraftSession minecraftSession, MinecraftByteBuf minecraftByteBuf) {
        this.minecraftSession = minecraftSession;
        payload = minecraftByteBuf.readLong();
    }

    public long getPayload() {
        return payload;
    }

    @Override
    public MinecraftSession getMinecraftSession() {
        return minecraftSession;
    }
}

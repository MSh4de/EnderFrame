package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketIn;
import eu.mshade.enderframe.protocol.MinecraftByteBuf;
import eu.mshade.enderframe.protocol.MinecraftSession;

public class MinecraftPacketInServerStatus implements MinecraftPacketIn {

    private MinecraftSession minecraftSession;

    @Override
    public void deserialize(MinecraftSession minecraftSession, MinecraftByteBuf minecraftByteBuf) {
        this.minecraftSession = minecraftSession;
    }

    @Override
    public MinecraftSession getMinecraftSession() {
        return minecraftSession;
    }
}

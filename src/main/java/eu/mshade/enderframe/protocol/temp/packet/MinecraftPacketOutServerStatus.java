package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.motd.MotdComponent;
import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.MinecraftByteBuf;

public class MinecraftPacketOutServerStatus implements MinecraftPacketOut {

    private final MotdComponent motdComponent;

    public MinecraftPacketOutServerStatus(MotdComponent motdComponent) {
        this.motdComponent = motdComponent;
    }

    @Override
    public void serialize(MinecraftByteBuf minecraftByteBuf) {
        minecraftByteBuf.writeValueAsString(motdComponent);
    }
}

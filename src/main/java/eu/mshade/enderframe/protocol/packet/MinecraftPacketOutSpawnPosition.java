package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.MinecraftByteBuf;
import eu.mshade.enderframe.world.Vector;

public class MinecraftPacketOutSpawnPosition implements MinecraftPacketOut {

    private Vector blockPosition;

    public MinecraftPacketOutSpawnPosition(Vector blockPosition) {
        this.blockPosition = blockPosition;
    }

    @Override
    public void serialize(MinecraftByteBuf minecraftByteBuf) {
        minecraftByteBuf.writeBlockPosition(blockPosition);
    }
}

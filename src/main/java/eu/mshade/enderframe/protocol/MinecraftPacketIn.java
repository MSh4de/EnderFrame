package eu.mshade.enderframe.protocol;

public interface MinecraftPacketIn {

    void deserialize(MinecraftSession minecraftSession, MinecraftByteBuf minecraftByteBuf);

    MinecraftSession getSessionWrapper();

}

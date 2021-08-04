package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.mojang.SkinParts;
import eu.mshade.enderframe.protocol.ProtocolVersion;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public interface Player extends LivingEntity {

    EnderFrameSessionHandler getEnderFrameSessionHandler();

    String getName();

    SocketAddress getSocketAddress();

    ProtocolVersion getProtocolVersion();

    int getPing();

    SkinParts getSkinParts();

    boolean unused();

    float getAbsorptionHearts();

    int getScore();
}

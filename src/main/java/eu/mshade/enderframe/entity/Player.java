package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.mojang.SkinParts;
import eu.mshade.enderframe.protocol.ProtocolVersion;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public abstract class Player extends LivingEntity {

    public abstract EnderFrameSessionHandler getEnderFrameSessionHandler();

    public abstract String getName();

    public abstract SocketAddress getSocketAddress();

    public abstract ProtocolVersion getProtocolVersion();

    public abstract int getPing();

    public abstract SkinParts getSkinParts();

    public abstract boolean unused();

    public abstract float getAbsorptionHearts();

    public abstract int getScore();
}

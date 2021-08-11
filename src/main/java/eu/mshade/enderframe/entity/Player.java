package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.EnderFrameSession;
import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.mojang.SkinParts;
import eu.mshade.enderframe.protocol.ProtocolVersion;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;
import eu.mshade.mwork.MOptional;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.UUID;

public abstract class Player extends LivingEntity {

    private EnderFrameSessionHandler enderFrameSessionHandler;
    private String name;
    private SocketAddress socketAddress;
    private ProtocolVersion protocolVersion;
    private int ping;
    private SkinParts skinParts;
    private boolean unused;
    private float absorptionHearts;
    private int score;

    public Player(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, EnderFrameSessionHandler enderFrameSessionHandler, String name, SocketAddress socketAddress, ProtocolVersion protocolVersion, int ping, SkinParts skinParts, boolean unused, float absorptionHearts, int score) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.enderFrameSessionHandler = enderFrameSessionHandler;
        this.name = name;
        this.socketAddress = socketAddress;
        this.protocolVersion = protocolVersion;
        this.ping = ping;
        this.skinParts = skinParts;
        this.unused = unused;
        this.absorptionHearts = absorptionHearts;
        this.score = score;
    }

    public EnderFrameSessionHandler getEnderFrameSessionHandler() {
        return enderFrameSessionHandler;
    }

    public String getName() {
        return name;
    }

    public SocketAddress getSocketAddress() {
        return socketAddress;
    }

    public ProtocolVersion getProtocolVersion() {
        return protocolVersion;
    }

    public int getPing() {
        return ping;
    }

    public SkinParts getSkinParts() {
        return skinParts;
    }

    public boolean isUnused() {
        return unused;
    }

    public float getAbsorptionHearts() {
        return absorptionHearts;
    }

    public int getScore() {
        return score;
    }
}

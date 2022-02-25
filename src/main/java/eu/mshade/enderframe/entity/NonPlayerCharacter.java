package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.GameMode;
import eu.mshade.enderframe.mojang.GameProfile;
import eu.mshade.enderframe.mojang.SkinParts;
import eu.mshade.enderframe.protocol.ProtocolVersion;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.net.SocketAddress;
import java.util.Optional;
import java.util.UUID;

public abstract class NonPlayerCharacter extends Player{

    public NonPlayerCharacter(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean potionEffectAmbient, byte numberOfArrowInEntity, boolean ai, String name, SocketAddress socketAddress, ProtocolVersion protocolVersion, int ping, SkinParts skinParts, float absorptionHearts, int score, Optional<String> playerListName, GameMode gameMode, GameProfile gameProfile) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType, health, potionEffectColor, potionEffectAmbient, numberOfArrowInEntity, ai, name, socketAddress, protocolVersion, ping, skinParts, absorptionHearts, score, playerListName, gameMode, gameProfile);
    }

}

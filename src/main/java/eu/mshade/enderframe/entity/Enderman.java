package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Enderman extends LivingEntity {

    /*
    TODO change primitive block at real object Block
     */
    protected short carriedBlock;
    protected byte carriedBlockData;
    protected boolean isScreaming;

    public Enderman(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean potionEffectAmbient, byte numberOfArrowInEntity, boolean ai, short carriedBlock, byte carriedBlockData, boolean isScreaming) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType, health, potionEffectColor, potionEffectAmbient, numberOfArrowInEntity, ai);
        this.carriedBlock = carriedBlock;
        this.carriedBlockData = carriedBlockData;
        this.isScreaming = isScreaming;
    }

    public short getCarriedBlock() {
        return this.carriedBlock;
    }

    public void setCarriedBlock(short carriedBlock) {
        this.carriedBlock = carriedBlock;
    }

    public byte getCarriedBlockData() {
        return this.carriedBlockData;
    }

    public void setCarriedBlockData(byte carriedBlockData) {
        this.carriedBlockData = carriedBlockData;
    }

    public boolean isScreaming() {
        return this.isScreaming;
    }

    public void setScreaming(boolean isScreaming) {
        this.isScreaming = isScreaming;
    }

}
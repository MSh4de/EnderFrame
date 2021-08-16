package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Enderman extends LivingEntity {

    private short carriedBlock;
    private byte carriedBlockData;
    private boolean isScreaming;

    public Enderman(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, short carriedBlock, byte carriedBlockData, boolean isScreaming) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.ENDERMAN, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.carriedBlock = carriedBlock;
        this.carriedBlockData = carriedBlockData;
        this.isScreaming = isScreaming;
    }

    public Enderman(Location location, int entityId, float health, short carriedBlock, byte carriedBlockData, boolean isScreaming){
        super(location, EntityType.ENDERMAN, entityId, health);
        this.carriedBlock = carriedBlock;
        this.carriedBlockData = carriedBlockData;
        this.isScreaming = isScreaming;
    }

    public Enderman(Location location, int entityId){
        this(location, entityId, 10, (short) 0, (byte) 0, false);
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

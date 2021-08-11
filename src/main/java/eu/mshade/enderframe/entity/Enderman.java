package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class Enderman extends LivingEntity {

    private short carriedBlock;
    private short carriedBlockData;
    private boolean isScreaming;

    public Enderman(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, EntityType entityType, Queue<Player> viewers, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, short carriedBlock, short carriedBlockData, boolean isScreaming) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, entityType, viewers, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.carriedBlock = carriedBlock;
        this.carriedBlockData = carriedBlockData;
        this.isScreaming = isScreaming;
    }

    public abstract short getCarriedBlock();

    public abstract void setCarriedBlock(short s);

    public abstract byte getCarriedBlockData();

    public abstract void setCarriedBlockData(byte carriedBlockData);

    public abstract boolean isScreaming();

    public abstract void setScreaming(boolean isScreaming);
}

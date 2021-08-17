package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class FurnaceMinecart extends Minecart {

    private boolean isPowered;

    public FurnaceMinecart(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, int shakingPower, int shakingDirection, int blockId, int blockData, int blockYPosition, boolean showBlock, float damageTaken, boolean isPowered) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.FURNACE_MINECART, shakingPower, shakingDirection, blockId, blockData, blockYPosition, showBlock, damageTaken);
        this.isPowered = isPowered;
    }

    public FurnaceMinecart(Location location, int entityId, boolean isPowered){
        super(location, EntityType.FURNACE_MINECART, entityId);
        this.isPowered = isPowered;
    }

    public FurnaceMinecart(Location location, int entityId){
        this(location, entityId, false);
    }

    public boolean isPowered() {
        return isPowered;
    }

    public void setPowered(boolean powered) {
        isPowered = powered;
    }
}

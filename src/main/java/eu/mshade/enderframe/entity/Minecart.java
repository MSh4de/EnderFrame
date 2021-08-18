package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Minecart extends Entity implements Damageable {

    private int shakingPower;
    private int shakingDirection;
    private int blockId;
    private int blockData;
    private int blockYPosition;
    private boolean showBlock;
    private float damageTaken;

    public Minecart(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, EntityType entityType, int shakingPower, int shakingDirection, int blockId, int blockData, int blockYPosition, boolean showBlock, float damageTaken) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, entityType);
        this.shakingPower = shakingPower;
        this.shakingDirection = shakingDirection;
        this.blockId = blockId;
        this.blockData = blockData;
        this.blockYPosition = blockYPosition;
        this.showBlock = showBlock;
        this.damageTaken = damageTaken;
    }

    public Minecart(Location location, int entityId, EntityType entityType, int shakingPower, int shakingDirection, int blockId, int blockData, int blockYPosition, boolean showBlock, float damageTaken){
        super(location, entityType, entityId);
        this.shakingPower = shakingPower;
        this.shakingDirection = shakingDirection;
        this.blockId = blockId;
        this.blockData = blockData;
        this.blockYPosition = blockYPosition;
        this.showBlock = showBlock;
        this.damageTaken = damageTaken;
    }

    public Minecart(Location location, EntityType entityType, int entityId) {
        this(location, entityId, entityType, 0, 0, 0, 0, 0, false, 0);
    }

    public Minecart(Location location, int entityId){
        this(location, EntityType.MINECART, entityId);
    }

    public int getShakingPower() {
        return shakingPower;
    }

    public void setShakingPower(int shakingPower) {
        this.shakingPower = shakingPower;
    }

    public int getShakingDirection() {
        return shakingDirection;
    }

    public void setShakingDirection(int shakingDirection) {
        this.shakingDirection = shakingDirection;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public int getBlockData() {
        return blockData;
    }

    public void setBlockData(int blockData) {
        this.blockData = blockData;
    }

    public int getBlockYPosition() {
        return blockYPosition;
    }

    public void setBlockYPosition(int blockYPosition) {
        this.blockYPosition = blockYPosition;
    }

    public boolean isShowBlock() {
        return showBlock;
    }

    public void setShowBlock(boolean showBlock) {
        this.showBlock = showBlock;
    }

    @Override
    public float getDamageTaken() {
        return damageTaken;
    }

    @Override
    public void setDamageTaken(float damageTaken) {
        this.damageTaken = damageTaken;
    }
}

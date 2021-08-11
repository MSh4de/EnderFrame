package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class Minecart extends Entity implements Damageable {

    private int shakingPower;
    private int shakingDirection;
    private int blockId;
    public int blockData;
    private int blockYPosition;
    private boolean showBlock;

    public Minecart(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, EntityType entityType, Queue<Player> viewers, int shakingPower, int shakingDirection, int blockId, int blockData, int blockYPosition, boolean showBlock) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, entityType, viewers);
        this.shakingPower = shakingPower;
        this.shakingDirection = shakingDirection;
        this.blockId = blockId;
        this.blockData = blockData;
        this.blockYPosition = blockYPosition;
        this.showBlock = showBlock;
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
}

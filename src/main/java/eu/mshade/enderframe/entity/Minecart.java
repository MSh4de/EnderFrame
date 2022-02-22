package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Minecart extends Entity implements Damageable {

    protected int shakingPower;
    protected int shakingDirection;
    protected int blockId;
    protected int blockData;
    protected int blockYPosition;
    protected boolean showBlock;

    public Minecart(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, int shakingPower, int shakingDirection, int blockId, int blockData, int blockYPosition, boolean showBlock) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType);
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

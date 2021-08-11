package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Rotation;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class ArmorStand extends LivingEntity {

    private boolean isSmall;
    private boolean hasGravity;
    private boolean removeBasePlate;
    private boolean marker;
    private Rotation headPosition;
    private Rotation bodyPosition;
    private Rotation leftArmPosition;
    private Rotation rightArmPosition;
    private Rotation leftLegPosition;
    private Rotation rightLegPosition;

    public ArmorStand(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isSmall, boolean hasGravity, boolean removeBasePlate, boolean marker, Rotation headPosition, Rotation bodyPosition, Rotation leftArmPosition, Rotation rightArmPosition, Rotation leftLegPosition, Rotation rightLegPosition) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isSmall = isSmall;
        this.hasGravity = hasGravity;
        this.removeBasePlate = removeBasePlate;
        this.marker = marker;
        this.headPosition = headPosition;
        this.bodyPosition = bodyPosition;
        this.leftArmPosition = leftArmPosition;
        this.rightArmPosition = rightArmPosition;
        this.leftLegPosition = leftLegPosition;
        this.rightLegPosition = rightLegPosition;
    }

    public boolean isSmall() {
        return isSmall;
    }

    public void setSmall(boolean small) {
        isSmall = small;
    }

    public boolean isHasGravity() {
        return hasGravity;
    }

    public void setHasGravity(boolean hasGravity) {
        this.hasGravity = hasGravity;
    }

    public boolean isRemoveBasePlate() {
        return removeBasePlate;
    }

    public void setRemoveBasePlate(boolean removeBasePlate) {
        this.removeBasePlate = removeBasePlate;
    }

    public boolean isMarker() {
        return marker;
    }

    public void setMarker(boolean marker) {
        this.marker = marker;
    }

    public Rotation getHeadPosition() {
        return headPosition;
    }

    public void setHeadPosition(Rotation headPosition) {
        this.headPosition = headPosition;
    }

    public Rotation getBodyPosition() {
        return bodyPosition;
    }

    public void setBodyPosition(Rotation bodyPosition) {
        this.bodyPosition = bodyPosition;
    }

    public Rotation getLeftArmPosition() {
        return leftArmPosition;
    }

    public void setLeftArmPosition(Rotation leftArmPosition) {
        this.leftArmPosition = leftArmPosition;
    }

    public Rotation getRightArmPosition() {
        return rightArmPosition;
    }

    public void setRightArmPosition(Rotation rightArmPosition) {
        this.rightArmPosition = rightArmPosition;
    }

    public Rotation getLeftLegPosition() {
        return leftLegPosition;
    }

    public void setLeftLegPosition(Rotation leftLegPosition) {
        this.leftLegPosition = leftLegPosition;
    }

    public Rotation getRightLegPosition() {
        return rightLegPosition;
    }

    public void setRightLegPosition(Rotation rightLegPosition) {
        this.rightLegPosition = rightLegPosition;
    }
}

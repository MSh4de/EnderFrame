package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Rotation;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class ArmorStand extends LivingEntity {

    private boolean isSmall;
    private boolean hasGravity;
    private boolean hasArms;
    private boolean removedBasePlate;
    private boolean marker;
    private Rotation headPosition;
    private Rotation bodyPosition;
    private Rotation leftArmPosition;
    private Rotation rightArmPosition;
    private Rotation leftLegPosition;
    private Rotation rightLegPosition;

    public ArmorStand(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isSmall, boolean hasGravity, boolean hasArms, boolean removedBasePlate, boolean marker, Rotation headPosition, Rotation bodyPosition, Rotation leftArmPosition, Rotation rightArmPosition, Rotation leftLegPosition, Rotation rightLegPosition) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.ARMOR_STAND, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isSmall = isSmall;
        this.hasGravity = hasGravity;
        this.hasArms = hasArms;
        this.removedBasePlate = removedBasePlate;
        this.marker = marker;
        this.headPosition = headPosition;
        this.bodyPosition = bodyPosition;
        this.leftArmPosition = leftArmPosition;
        this.rightArmPosition = rightArmPosition;
        this.leftLegPosition = leftLegPosition;
        this.rightLegPosition = rightLegPosition;
    }

    public ArmorStand(Location location, int entityId, boolean isSmall, boolean hasGravity, boolean removedBasePlate, boolean marker) {
        super(location, EntityType.ARMOR_STAND, entityId, 20f);
        this.isSmall = isSmall;
        this.hasGravity = hasGravity;
        this.removedBasePlate = removedBasePlate;
        this.marker = marker;
        this.headPosition = new Rotation(0, 0, 0);
        this.bodyPosition = new Rotation(0, 0, 0);
        this.leftArmPosition = new Rotation(0, 0, 0);
        this.rightArmPosition = new Rotation(0, 0, 0);
        this.leftLegPosition = new Rotation(0, 0, 0);
        this.rightLegPosition = new Rotation(0, 0, 0);
    }

    public ArmorStand(Location location, int entityId) {
        this(location, entityId, false, false, false, false);
    }

    public boolean isSmall() {
        return isSmall;
    }

    public void setSmall(boolean small) {
        isSmall = small;
    }

    public boolean hasGravity() {
        return hasGravity;
    }

    public void setHasGravity(boolean hasGravity) {
        this.hasGravity = hasGravity;
    }

    public boolean hasArms(){
        return hasArms;
    }

    public void setHasArms(boolean hasArms){
        this.hasArms = hasArms;
    }

    public boolean isRemovedBasePlate() {
        return removedBasePlate;
    }

    public void setRemovedBasePlate(boolean removedBasePlate) {
        this.removedBasePlate = removedBasePlate;
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

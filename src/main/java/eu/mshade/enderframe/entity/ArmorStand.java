package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Rotation;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class ArmorStand extends LivingEntity {


    protected boolean small;
    protected boolean gravity;
    protected boolean arms;
    protected boolean basePlate;
    protected boolean marker;
    protected Rotation headPosition;
    protected Rotation bodyPosition;
    protected Rotation leftArmPosition;
    protected Rotation rightArmPosition;
    protected Rotation leftLegPosition;
    protected Rotation rightLegPosition;

    public ArmorStand(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean potionEffectAmbient, byte numberOfArrowInEntity, boolean ai, boolean small, boolean gravity, boolean arms, boolean basePlate, boolean marker, Rotation headPosition, Rotation bodyPosition, Rotation leftArmPosition, Rotation rightArmPosition, Rotation leftLegPosition, Rotation rightLegPosition) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType, health, potionEffectColor, potionEffectAmbient, numberOfArrowInEntity, ai);
        this.small = small;
        this.gravity = gravity;
        this.arms = arms;
        this.basePlate = basePlate;
        this.marker = marker;
        this.headPosition = headPosition;
        this.bodyPosition = bodyPosition;
        this.leftArmPosition = leftArmPosition;
        this.rightArmPosition = rightArmPosition;
        this.leftLegPosition = leftLegPosition;
        this.rightLegPosition = rightLegPosition;
    }

    public boolean isSmall() {
        return small;
    }

    public void setSmall(boolean small) {
        this.small = small;
    }

    public boolean hasGravity() {
        return gravity;
    }

    public void setGravity(boolean gravity) {
        this.gravity = gravity;
    }

    public boolean hasArms(){
        return arms;
    }

    public void setArms(boolean arms){
        this.arms = arms;
    }

    public boolean isBasePlate() {
        return basePlate;
    }

    public void setBasePlate(boolean basePlate) {
        this.basePlate = basePlate;
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

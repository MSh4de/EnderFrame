package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Rotation;

public abstract class ArmorStand extends LivingEntity {

    public abstract boolean isSmall();

    public abstract void setSmall(boolean isSmall);

    public abstract boolean hasGravity();

    public abstract void setGravity(boolean isGravity);

    public abstract boolean hasArms();

    public abstract void setHasArms(boolean hasArms);

    public abstract boolean removeBasePlate();

    public abstract void setRemoveBasePlate(boolean removeBasePlate);

    public abstract boolean marker();

    public abstract void setMarker(boolean marker);

    public abstract Rotation getHeadPostion();

    public abstract void setHeadPosition(Rotation rotation);

    public abstract Rotation getBodyPosition();

    public abstract void setBodyPosition(Rotation rotation);

    public abstract Rotation getLeftArmPosition();

    public abstract void setLeftArmPosition(Rotation rotation);

    public abstract Rotation getRightArmPosition();

    public abstract void setRightArmPosition(Rotation rotation);

    public abstract Rotation getLeftLegPosition();

    public abstract void setLeftLegPosition(Rotation rotation);

    public abstract Rotation getRightLegPosition();

    public abstract void setRightLegPosition(Rotation rotation);
}

package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Rotation;

public interface ArmorStand extends LivingEntity {

    boolean isSmall();

    void setSmall(boolean isSmall);

    boolean hasGravity();

    void setGravity(boolean isGravity);

    boolean hasArms();

    void setHasArms(boolean hasArms);

    boolean removeBasePlate();

    void setRemoveBasePlate(boolean removeBasePlate);

    boolean marker();

    void setMarker(boolean marker);

    Rotation getHeadPostion();

    void setHeadPosition(Rotation rotation);

    Rotation getBodyPosition();

    void setBodyPosition(Rotation rotation);

    Rotation getLeftArmPosition();

    void setLeftArmPosition(Rotation rotation);

    Rotation getRightArmPosition();

    void setRightArmPosition(Rotation rotation);

    Rotation getLeftLegPosition();

    void setLeftLegPosition(Rotation rotation);

    Rotation getRightLegPosition();

    void setRightLegPosition(Rotation rotation);
}

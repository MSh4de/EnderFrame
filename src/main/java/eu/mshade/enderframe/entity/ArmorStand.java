package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Rotation;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface ArmorStand extends LivingEntity {

    /*
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
     */



    boolean isSmall();

    void setSmall(boolean small);

    boolean hasGravity();

    void setHasGravity(boolean hasGravity);

    boolean hasArms();

    void setHasArms(boolean hasArms);

    boolean isRemovedBasePlate();

    void setRemovedBasePlate(boolean removedBasePlate);

    boolean isMarker();

    void setMarker(boolean marker);

    Rotation getHeadPosition();

     void setHeadPosition(Rotation headPosition);

     Rotation getBodyPosition();

     void setBodyPosition(Rotation bodyPosition);

     Rotation getLeftArmPosition();

     void setLeftArmPosition(Rotation leftArmPosition);

     Rotation getRightArmPosition();

    void setRightArmPosition(Rotation rightArmPosition);

    Rotation getLeftLegPosition();

    void setLeftLegPosition(Rotation leftLegPosition);

    Rotation getRightLegPosition();

    void setRightLegPosition(Rotation rightLegPosition);
}

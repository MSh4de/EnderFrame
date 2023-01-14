package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class ArmorStand extends LivingEntity {

    /*
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

     */

    public ArmorStand(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.ARMOR_STAND);
    }

    public ArmorStand(Location location, int entityId) {
        this(location, new Vector(), entityId, UUID.randomUUID());
    }
}

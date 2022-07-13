package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Horse extends LivingEntity implements Tameable, Ageable {

    /*
    private boolean hasSaddle;
    private boolean hasChest;
    private boolean bred;
    private boolean rearing;
    private boolean mouthOpen;
    private HorseType horseType;
    private HorseColor horseColor;
    private HorseStyle horseStyle;
    private HorseArmor horseArmor;

     */
    public Horse(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.HORSE);
    }

    public Horse(Location location, int entityId) {
        super(location, entityId, EntityType.HORSE);
    }




}

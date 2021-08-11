package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public interface Damageable {

    float getDamageTaken();

   void setDamageTaken(float damageTaken);

}

package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class LivingEntity extends Entity {


    protected float health;
    protected int potionEffectColor;
    protected boolean potionEffectAmbient;
    protected byte numberOfArrowInEntity;
    protected boolean ai;


    public LivingEntity(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean potionEffectAmbient, byte numberOfArrowInEntity, boolean ai) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType);
        this.health = health;
        this.potionEffectColor = potionEffectColor;
        this.potionEffectAmbient = potionEffectAmbient;
        this.numberOfArrowInEntity = numberOfArrowInEntity;
        this.ai = ai;
    }

    public float getHealth(){
       return this.health;
   }

   public void setHealth(float health){
       this.health = health;
   }

   public int getPotionEffectColor(){
       return this.potionEffectColor;
   }

   public void setPotionEffectColor(int potionEffectColor){
       this.potionEffectColor = potionEffectColor;
   }

   public boolean isPotionEffectAmbient(){
       return this.potionEffectAmbient;
   }

   public void setPotionEffectAmbient(boolean potionEffectAmbient){
       this.potionEffectAmbient = potionEffectAmbient;
   }

   public byte getNumberOfArrowInEntity(){
       return this.numberOfArrowInEntity;
   }

   public void setNumberOfArrowInEntity(byte numberOfArrowInEntity){
       this.numberOfArrowInEntity = numberOfArrowInEntity;
   }

   public boolean hasAI(){
       return this.ai;
   }

   public void setAI(boolean ai){
       this.ai = ai;
   }
}

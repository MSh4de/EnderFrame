package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Zombie extends LivingEntity implements Ageable{


    private boolean isChild;
    private boolean isVillager;
    private boolean isConverting;
    private int age;


    public Zombie(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isChild, boolean isVillager, boolean isConverting, int age) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.ZOMBIE, new ConcurrentLinkedQueue<>(), health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isChild = isChild;
        this.isVillager = isVillager;
        this.isConverting = isConverting;
        this.age = age;
    }

    public Zombie(Location location, int entityId, float health, boolean isChild, boolean isVillager, boolean isConverting, int age) {
        super(location, EntityType.ZOMBIE, entityId, health);
        this.isChild = isChild;
        this.isVillager = isVillager;
        this.isConverting = isConverting;
        this.age = age;
    }

    public boolean isChild() {
        return this.isChild;
    }

    public void setChild(boolean isChild) {
        this.isChild = isChild;
    }

    public boolean isVillager() {
        return this.isVillager;
    }

    public void setVillager(boolean isVillager) {
        this.isVillager = isVillager;
    }

    public boolean isConverting() {
        return this.isConverting;
    }

    public void setConverting(boolean isConverting) {
        this.isConverting = isConverting;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}

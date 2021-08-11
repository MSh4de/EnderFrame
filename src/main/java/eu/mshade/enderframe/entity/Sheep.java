package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class Sheep extends LivingEntity implements Ageable{

    private SheepColor sheepColor;
    private boolean isSheared;
    private int age;

    public Sheep(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, EntityType entityType, Queue<Player> viewers, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, SheepColor sheepColor, boolean isSheared, int age) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, entityType, viewers, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.sheepColor = sheepColor;
        this.isSheared = isSheared;
        this.age = age;
    }

    public SheepColor getSheepColor() {
        return sheepColor;
    }

    public void setSheepColor(SheepColor sheepColor) {
        this.sheepColor = sheepColor;
    }

    public boolean isSheared() {
        return isSheared;
    }

    public void setSheared(boolean sheared) {
        isSheared = sheared;
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

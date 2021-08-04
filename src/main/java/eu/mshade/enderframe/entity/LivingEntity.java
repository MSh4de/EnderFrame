package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.world.Location;

import java.util.HashSet;
import java.util.Set;

public interface LivingEntity extends Entity {

    float getHealth();

    void setHealth(float health);

    int getPotionEffectColor();

    void setPotionEffectColor(int color);

    boolean isPotionEffectAmbient();

    void setPotionEffectAmbient(boolean ambient);

    byte getNumberOfArrowInEntity();

    void setNumberOfArrowInEntity(byte b);

    boolean isAIDisable();

    void setAIDisable(boolean isDisable);
}

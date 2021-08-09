package eu.mshade.enderframe.entity;

public abstract class LivingEntity extends Entity {

    public abstract float getHealth();

    public abstract void setHealth(float health);

    public abstract int getPotionEffectColor();

    public abstract void setPotionEffectColor(int color);

    public abstract boolean isPotionEffectAmbient();

    public abstract void setPotionEffectAmbient(boolean ambient);

    public abstract byte getNumberOfArrowInEntity();

    public abstract void setNumberOfArrowInEntity(byte b);

    public abstract boolean isAIDisable();

    public abstract void setAIDisable(boolean isDisable);
}

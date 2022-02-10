package eu.mshade.enderframe.entity;

public interface LivingEntity extends Entity {

    /*
    private float health;
    private int potionEffectColor;
    private boolean isPotionEffectAmbient;
    private byte numberOfArrowInEntity;
    private boolean isAIDisable;

     */


    float getHealth();

    void setHealth(float health);

    int getPotionEffectColor();

    void setPotionEffectColor(int potionEffectColor);

    boolean isPotionEffectAmbient();

    void setPotionEffectAmbient(boolean potionEffectAmbient);

    byte getNumberOfArrowInEntity();

    void setNumberOfArrowInEntity(byte numberOfArrowInEntity);

    boolean hasAI();

    void setAI(boolean ai);
}

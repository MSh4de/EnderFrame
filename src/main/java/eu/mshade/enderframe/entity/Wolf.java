package eu.mshade.enderframe.entity;

public interface Wolf extends Tameable {

    boolean isAngry();

    void setIsAngry(boolean isAngry);

    float getHealth();

    void setHealth(float health);

    boolean begging();

    void setBegging(boolean begging);

    boolean getCollarColor();

    void setCollarColor(boolean collarColor);
}

package eu.mshade.enderframe.entity;

public interface Tameable {

    boolean isSitting();

    void setSitting(boolean isSitting);

    boolean isTamed();

    void setTamed(boolean isTamed);

    String getOwner();
}

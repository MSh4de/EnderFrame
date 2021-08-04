package eu.mshade.enderframe.entity;

public interface Tameable extends Ageable {

    boolean isSitting();

    void setSitting(boolean isSitting);

    boolean isTame();

    void setTame(boolean isTame);

    String getOwner();
}

package eu.mshade.enderframe.entity;

public interface Ageable {

    int getAge();

    void setAge(int age);

    void setAgeLock(boolean ageLock);

    boolean getAgeLock();

    void setBaby();

    void setAdult();

    boolean isAdult();

}

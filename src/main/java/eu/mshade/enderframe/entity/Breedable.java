package eu.mshade.enderframe.entity;

public interface Breedable {

    void setAgeLock(boolean ageLock);

    boolean isAgeLocked();

    boolean isBreedable();

    void setBreedable(boolean breedable);

}

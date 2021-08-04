package eu.mshade.enderframe.entity;

public interface Guardian extends LivingEntity {

    boolean isElderly();

    void setElderly(boolean isElderly);

    boolean isRetractingSpikes();

    void setRetractingSpikes(boolean isRetractingSpikes);

    int getTargetEntityId();

    void setTargetEntityId(int targetEntityId);
}

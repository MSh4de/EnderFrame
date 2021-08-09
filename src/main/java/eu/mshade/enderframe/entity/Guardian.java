package eu.mshade.enderframe.entity;

public abstract class Guardian extends LivingEntity {

    public abstract boolean isElderly();

    public abstract void setElderly(boolean isElderly);

    public abstract boolean isRetractingSpikes();

    public abstract void setRetractingSpikes(boolean isRetractingSpikes);

    public abstract int getTargetEntityId();

    public abstract void setTargetEntityId(int targetEntityId);
}

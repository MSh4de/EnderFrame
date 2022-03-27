package eu.mshade.enderframe.metadata;

public abstract class EntityMetadata<T> {

    private T t;
    private EntityMetadataType entityMetadataType;

    public EntityMetadata(T t, EntityMetadataType entityMetadataType) {
        this.t = t;
        this.entityMetadataType = entityMetadataType;
    }

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public EntityMetadataType getEntityMetadataType() {
        return entityMetadataType;
    }
}

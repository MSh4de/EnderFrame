package eu.mshade.enderframe.metadata;

public interface EntityMetadata<T> {

    void set(T t);

    T get();

    EntityMetadataType getEntityMetadataType();

}

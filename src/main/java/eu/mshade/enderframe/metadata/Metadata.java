package eu.mshade.enderframe.metadata;

public interface Metadata<T> {

    T get();

    MetadataType getMetadataType();

}

package eu.mshade.enderframe.metadata;


public interface MetadataWrapper<T> {

    Metadata<?> wrap(T t);

}

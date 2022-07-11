package eu.mshade.enderframe.metadata;

public abstract class MetadataKeyValue<K extends MetadataKey, V> {

    protected K metadataKey;
    protected V metadataValue;

    public MetadataKeyValue(K metadataKey, V metadataValue) {
        this.metadataKey = metadataKey;
        this.metadataValue = metadataValue;
    }

    public K getMetadataKey() {
        return metadataKey;
    }

    public V getMetadataValue() {
        return metadataValue;
    }

    public void setMetadataValue(V metadataValue) {
        this.metadataValue = metadataValue;
    }


}

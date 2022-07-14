package eu.mshade.enderframe.metadata;

public abstract class MetadataKeyValue<V> {

    protected MetadataKey metadataKey;
    protected V metadataValue;

    public MetadataKeyValue(MetadataKey metadataKey, V metadataValue) {
        this.metadataKey = metadataKey;
        this.metadataValue = metadataValue;
    }

    public MetadataKey getMetadataKey() {
        return metadataKey;
    }

    public V getMetadataValue() {
        return metadataValue;
    }

    public void setMetadataValue(V metadataValue) {
        this.metadataValue = metadataValue;
    }

    @Override
    public String toString() {
        return "MetadataKeyValue{" +
                "metadataKey=" + metadataKey +
                ", metadataValue=" + metadataValue +
                '}';
    }
}

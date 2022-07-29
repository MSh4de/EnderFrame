package eu.mshade.enderframe.metadata;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetadataKeyValue<?> that = (MetadataKeyValue<?>) o;
        return Objects.equals(metadataKey, that.metadataKey) && Objects.equals(metadataValue, that.metadataValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadataKey, metadataValue);
    }
}

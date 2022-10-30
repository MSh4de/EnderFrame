package eu.mshade.enderframe.metadata;

import java.util.*;

public class MetadataKeyValueBucket {

    protected final Map<MetadataKey, MetadataKeyValue<?>> metadataKeyValueByMetadataKey = new HashMap<>();
    protected final Set<MetadataKey> metadataKeyUpdated = new HashSet<>();
    protected boolean trackUpdates;

    public MetadataKeyValueBucket(boolean trackUpdates) {
        this.trackUpdates = trackUpdates;
    }

    public MetadataKeyValueBucket() {
        this(true);
    }

    public void setMetadataKeyValue(MetadataKeyValue<?> entityMetadata){
        if (trackUpdates) this.metadataKeyUpdated.add(entityMetadata.getMetadataKey());
        this.metadataKeyValueByMetadataKey.put(entityMetadata.getMetadataKey(), entityMetadata);
    }

    public boolean hasMetadataKeyValue(MetadataKey metadataKey){
        return this.metadataKeyValueByMetadataKey.containsKey(metadataKey);
    }

    public <T> MetadataKeyValue<T> getMetadataKeyValueOrDefault(MetadataKey metadataKey, MetadataKeyValue<T> t){
        return (MetadataKeyValue<T>) this.metadataKeyValueByMetadataKey.getOrDefault(metadataKey, t);
    }

    public <T extends MetadataKeyValue<?>> T getMetadataKeyValue(MetadataKey metadataKey, Class<T> type){
        MetadataKeyValue<?> metadataKeyValue = this.metadataKeyValueByMetadataKey.get(metadataKey);
        if (metadataKeyValue == null) return null;
        return type.cast(metadataKeyValue);
    }

    public <T> T getValueOfMetadataKeyValue(MetadataKey metadataKey, Class<T> type){
        MetadataKeyValue<?> metadataKeyValue = this.metadataKeyValueByMetadataKey.get(metadataKey);
        if (metadataKeyValue == null) return null;
        return type.cast(metadataKeyValue.getMetadataValue());
    }


    public Collection<MetadataKeyValue<?>> getMetadataKeyValues(){
        return this.metadataKeyValueByMetadataKey.values();
    }

    public Collection<MetadataKey> consumeUpdatedMetadataKeyValue(){
        Set<MetadataKey> copy = new HashSet<>(this.metadataKeyUpdated);
        this.metadataKeyUpdated.clear();
        return copy;
    }

    public void clear(){
        this.metadataKeyValueByMetadataKey.clear();
        this.metadataKeyUpdated.clear();
    }

    public boolean isEmpty(){
        return this.metadataKeyValueByMetadataKey.isEmpty();
    }

    public void toggleTrackUpdates(boolean trackUpdates){
        this.trackUpdates = trackUpdates;
    }

    @Override
    public String toString() {
        return "MetadataKeyValueBucket{" +
                "metadataKeyValueByMetadataKey=" + metadataKeyValueByMetadataKey +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetadataKeyValueBucket that = (MetadataKeyValueBucket) o;
        return trackUpdates == that.trackUpdates && Objects.equals(metadataKeyValueByMetadataKey, that.metadataKeyValueByMetadataKey) && Objects.equals(metadataKeyUpdated, that.metadataKeyUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadataKeyValueByMetadataKey, metadataKeyUpdated, trackUpdates);
    }
}
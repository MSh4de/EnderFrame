package eu.mshade.enderframe.metadata;

import java.util.*;

public class MetadataKeyValueBucket {

    protected final Map<MetadataKey, MetadataKeyValue<?>> metadataKeyValueByMetadataKey = new HashMap<>();
    protected final Set<MetadataKey> metadataKeyUpdated = new HashSet<>();

    public void setMetadataKeyValue(MetadataKeyValue<?> entityMetadata){
        this.metadataKeyUpdated.add(entityMetadata.getMetadataKey());
        this.metadataKeyValueByMetadataKey.put(entityMetadata.getMetadataKey(), entityMetadata);
    }

    public boolean hasMetadataKeyValue(MetadataKey metadataKey){
        return this.metadataKeyValueByMetadataKey.containsKey(metadataKey);
    }

    public <T> MetadataKeyValue<T> getMetadataKeyValueOrDefault(MetadataKey metadataKey, MetadataKeyValue<T> t){
        return (MetadataKeyValue<T>) this.metadataKeyValueByMetadataKey.getOrDefault(metadataKey, t);
    }

    public <T extends MetadataKeyValue<?>> T getMetadataKeyValue(MetadataKey metadataKey, Class<T> type){
        return type.cast(this.metadataKeyValueByMetadataKey.get(metadataKey));
    }

    public <T> T getValueOfMetadataKeyValue(MetadataKey metadataKey, Class<T> type){
        return type.cast(this.metadataKeyValueByMetadataKey.get(metadataKey).getMetadataValue());
    }


    public Collection<MetadataKeyValue<?>> getMetadataKeyValues(){
        return this.metadataKeyValueByMetadataKey.values();
    }

    public Collection<MetadataKey> consumeUpdatedMetadataKeyValue(){
        Set<MetadataKey> copy = new HashSet<>(this.metadataKeyUpdated);
        this.metadataKeyUpdated.clear();
        return copy;
    }

    @Override
    public String toString() {
        return "MetadataKeyValueBucket{" +
                "metadataKeyValueByMetadataKey=" + metadataKeyValueByMetadataKey +
                '}';
    }
}

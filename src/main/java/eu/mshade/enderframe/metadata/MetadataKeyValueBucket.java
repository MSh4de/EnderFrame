package eu.mshade.enderframe.metadata;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MetadataKeyValueBucket {

    protected final Map<MetadataKey, MetadataKeyValue<?>> metadataKeyValueByMetadataKey = new HashMap<>();

    public void setMetadataKeyValue(MetadataKeyValue<?> entityMetadata){
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

    @Override
    public String toString() {
        return "MetadataKeyValueBucket{" +
                "metadataKeyValueByMetadataKey=" + metadataKeyValueByMetadataKey +
                '}';
    }
}

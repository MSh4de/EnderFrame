package eu.mshade.enderframe.metadata;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MetadataKeyValueBucket {

    protected final Map<MetadataKey, MetadataKeyValue<MetadataKey, ?>> metadataKeyValueByMetadataKey = new HashMap<>();

    public void setMetadataKeyValue(MetadataKeyValue<MetadataKey, ?> entityMetadata){
        this.metadataKeyValueByMetadataKey.put(entityMetadata.getMetadataKey(), entityMetadata);
    }

    public boolean hasMetadataKeyValue(MetadataKey metadataKey){
        return this.metadataKeyValueByMetadataKey.containsKey(metadataKey);
    }

    public <T> MetadataKeyValue<MetadataKey, T> getMetadataKeyValueOrDefault(MetadataKey metadataKey, MetadataKeyValue<MetadataKey, T> t){
        return (MetadataKeyValue<MetadataKey, T>) this.metadataKeyValueByMetadataKey.getOrDefault(metadataKey, t);
    }

    public <T extends MetadataKeyValue<MetadataKey, ?>> T getMetadataKeyValue(MetadataKey metadataKey, Class<T> type){
        return type.cast(this.metadataKeyValueByMetadataKey.get(metadataKey));
    }

    public <T> T getValueOfMetadataKeyValue(MetadataKey metadataKey, Class<T> type){
        return type.cast(this.metadataKeyValueByMetadataKey.get(metadataKey).getMetadataValue());
    }


    public Collection<MetadataKeyValue<MetadataKey, ?>> getMetadataKeyValues(){
        return this.metadataKeyValueByMetadataKey.values();
    }

}

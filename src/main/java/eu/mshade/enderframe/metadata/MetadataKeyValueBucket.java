package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.metadata.world.WorldMetadataType;
import eu.mshade.enderframe.world.World;
import eu.mshade.enderframe.world.metadata.SeedWorldMetadata;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MetadataKeyValueBucket<K extends MetadataKey> {

    protected final Map<K, MetadataKeyValue<K, ?>> metadataKeyValueByMetadataKey = new HashMap<>();

    public void setMetadataKeyValue(MetadataKeyValue<K, ?> entityMetadata){
        this.metadataKeyValueByMetadataKey.put(entityMetadata.getMetadataKey(), entityMetadata);
    }

    public boolean hasMetadataKeyValue(K metadataKey){
        return this.metadataKeyValueByMetadataKey.containsKey(metadataKey);
    }

    public <T> MetadataKeyValue<K, T> getMetadataKeyValueOrDefault(K metadataKey, MetadataKeyValue<K, T> t){
        return (MetadataKeyValue<K, T>) this.metadataKeyValueByMetadataKey.getOrDefault(metadataKey, t);
    }

    public <T extends MetadataKeyValue<K, ?>> T getMetadataKeyValue(K metadataKey, Class<T> type){
        return type.cast(this.metadataKeyValueByMetadataKey.get(metadataKey));
    }

    public <T> T getValueOfMetadataKeyValue(K metadataKey, Class<T> type){
        return type.cast(this.metadataKeyValueByMetadataKey.get(metadataKey).getMetadataValue());
    }


    public Collection<MetadataKeyValue<K, ?>> getMetadataKeyValues(){
        return this.metadataKeyValueByMetadataKey.values();
    }

}

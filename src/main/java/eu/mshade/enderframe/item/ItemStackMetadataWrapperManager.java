package eu.mshade.enderframe.item;

import eu.mshade.enderframe.metadata.MetadataKey;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class ItemStackMetadataWrapperManager {

    protected Map<MetadataKey, ItemStackMetadataWrapper> itemStackMetadataBufferByMetadataKey = new HashMap<>();

    public void registerBuffer(MetadataKey metadataKey, ItemStackMetadataWrapper itemStackMetadataWrapper){
        this.itemStackMetadataBufferByMetadataKey.put(metadataKey, itemStackMetadataWrapper);
    }

    public boolean hasBuffer(MetadataKey metadataKey){
        return this.itemStackMetadataBufferByMetadataKey.containsKey(metadataKey);
    }

    public ItemStackMetadataWrapper getItemStackMetadataBuffer(MetadataKey metadataKey){
        return this.itemStackMetadataBufferByMetadataKey.get(metadataKey);
    }

    public Collection<MetadataKey> getMetadataKeys(){
        return this.itemStackMetadataBufferByMetadataKey.keySet();
    }

    public Collection<ItemStackMetadataWrapper> getItemStackMetadataBuffers(){
        return this.itemStackMetadataBufferByMetadataKey.values();
    }



}

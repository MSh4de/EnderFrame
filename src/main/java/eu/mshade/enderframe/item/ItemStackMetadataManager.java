package eu.mshade.enderframe.item;

import eu.mshade.enderframe.metadata.MetadataKey;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class ItemStackMetadataManager {

    protected Map<MetadataKey, ItemStackMetadataBuffer> itemStackMetadataBufferByMetadataKey = new HashMap<>();

    public void registerBuffer(MetadataKey metadataKey, ItemStackMetadataBuffer itemStackMetadataBuffer){
        this.itemStackMetadataBufferByMetadataKey.put(metadataKey, itemStackMetadataBuffer);
    }

    public boolean hasBuffer(MetadataKey metadataKey){
        return this.itemStackMetadataBufferByMetadataKey.containsKey(metadataKey);
    }

    public ItemStackMetadataBuffer getItemStackMetadataBuffer(MetadataKey metadataKey){
        return this.itemStackMetadataBufferByMetadataKey.get(metadataKey);
    }

    public Collection<MetadataKey> getMetadataKeys(){
        return this.itemStackMetadataBufferByMetadataKey.keySet();
    }

    public Collection<ItemStackMetadataBuffer> getItemStackMetadataBuffers(){
        return this.itemStackMetadataBufferByMetadataKey.values();
    }



}

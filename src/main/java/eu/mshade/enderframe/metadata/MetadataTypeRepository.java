package eu.mshade.enderframe.metadata;

import java.util.HashMap;
import java.util.Map;

public class MetadataTypeRepository {

    private final Map<MetadataType, Integer> metadataIndex = new HashMap<>();

    public void registerMetadataIndex(MetadataType type, int index) {
        this.metadataIndex.put(type, index);
    }

    public int getMetadataIndex(MetadataType metadataType){
        return this.metadataIndex.get(metadataType);
    }
}

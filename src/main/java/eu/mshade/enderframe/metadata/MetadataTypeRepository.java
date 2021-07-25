package eu.mshade.enderframe.metadata;

import java.util.HashMap;
import java.util.Map;

public class MetadataTypeRepository {
    private final Map<MetadataType, Integer> metadataTypeIndex = new HashMap<>();

    public void registerMetadataIndex(MetadataType type, int index) {
        this.metadataTypeIndex.put(type,index);
    }

    public int getMetadataIndex(MetadataType metadataType){
        return this.metadataTypeIndex.get(metadataType);
    }

}

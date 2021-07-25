package eu.mshade.enderframe.metadata;

import java.util.HashMap;
import java.util.Map;

public class MetadataRepository {
    private final Map<MetadataMeaning, Integer> metadataIndex = new HashMap<>();
    private final Map<MetadataMeaning, MetadataType> metadataType = new HashMap<>();

    public void registerMetadataIndex(int index, MetadataType type, MetadataMeaning metadataMeaning) {
        this.metadataIndex.put(metadataMeaning,index);
        this.metadataType.put(metadataMeaning,type);
    }

    public int getMetadataIndex(MetadataMeaning metadataMeaning){
        return this.metadataIndex.get(metadataMeaning);
    }

    public MetadataType getMetadataType(MetadataMeaning metadataMeaning){
        return this.metadataType.get(metadataMeaning);
    }
}

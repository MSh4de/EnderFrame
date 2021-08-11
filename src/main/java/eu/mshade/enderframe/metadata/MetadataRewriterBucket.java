package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.metadata.MetadataMeaning;

import java.util.HashMap;
import java.util.Map;

public abstract class MetadataRewriterBucket {

   private final Map<MetadataMeaning, MetadataRewriter> metadataRewriter = new HashMap<>();

    protected void registerMetadataRewriter(MetadataMeaning metadataMeaning, MetadataRewriter metadataRewriter){
        this.metadataRewriter.put(metadataMeaning, metadataRewriter);
    }

    public MetadataRewriter getMetadataRewriter(MetadataMeaning metadataMeaning){
        return this.metadataRewriter.get(metadataMeaning);
    }

}

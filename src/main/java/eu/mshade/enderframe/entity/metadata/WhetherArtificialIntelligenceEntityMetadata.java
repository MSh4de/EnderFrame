package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class WhetherArtificialIntelligenceEntityMetadata extends MetadataKeyValue<Boolean> {

    public WhetherArtificialIntelligenceEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.WHETHER_ARTIFICIAL_INTELLIGENCE, aBoolean);
    }

}

package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class WhetherArtificialIntelligenceEntityMetadata extends EntityMetadataKeyValue<Boolean> {

    public WhetherArtificialIntelligenceEntityMetadata(Boolean aBoolean) {
        super(EntityMetadataKey.WHETHER_ARTIFICIAL_INTELLIGENCE, aBoolean);
    }

}

package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class WhetherArtificialIntelligenceEntityMetadata extends EntityMetadata<Boolean> {

    public WhetherArtificialIntelligenceEntityMetadata(Boolean aBoolean) {
        super(aBoolean, EntityMetadataType.WHETHER_ARTIFICIAL_INTELLIGENCE);
    }

}

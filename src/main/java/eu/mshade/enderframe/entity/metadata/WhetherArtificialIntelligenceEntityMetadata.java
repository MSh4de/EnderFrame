package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class WhetherArtificialIntelligenceEntityMetadata implements EntityMetadata<Boolean> {

    private boolean artificialIntelligence;

    @Override
    public void set(Boolean aBoolean) {
        this.artificialIntelligence = aBoolean;
    }

    @Override
    public Boolean get() {
        return this.artificialIntelligence;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.WHETHER_ARTIFICIAL_INTELLIGENCE;
    }
}

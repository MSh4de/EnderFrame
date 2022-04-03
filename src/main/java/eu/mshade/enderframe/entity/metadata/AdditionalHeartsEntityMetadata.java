package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class AdditionalHeartsEntityMetadata extends EntityMetadata<Float> {

    public AdditionalHeartsEntityMetadata(Float aFloat) {
        super(aFloat, EntityMetadataType.ADDITIONAL_HEARTS);
    }
}

package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class AdditionalHeartsEntityMetadata extends EntityMetadataKeyValue<Float> {

    public AdditionalHeartsEntityMetadata(Float aFloat) {
        super(EntityMetadataKey.ADDITIONAL_HEARTS, aFloat);


    }
}

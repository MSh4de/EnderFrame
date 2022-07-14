package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class AdditionalHeartsEntityMetadata extends MetadataKeyValue<Float> {

    public AdditionalHeartsEntityMetadata(Float aFloat) {
        super(EntityMetadataKey.ADDITIONAL_HEARTS, aFloat);


    }
}

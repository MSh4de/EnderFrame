package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class NumberOfArrowEntityMetadata extends MetadataKeyValue<Integer> {

    public NumberOfArrowEntityMetadata(Integer integer) {
        super(EntityMetadataKey.NUMBER_OF_ARROWS_IN_ENTITY, integer);
    }

}

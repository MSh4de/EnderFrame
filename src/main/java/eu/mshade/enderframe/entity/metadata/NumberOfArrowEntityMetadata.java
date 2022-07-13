package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class NumberOfArrowEntityMetadata extends EntityMetadataKeyValue<Integer> {

    public NumberOfArrowEntityMetadata(Integer integer) {
        super(EntityMetadataKey.NUMBER_OF_ARROWS_IN_ENTITY, integer);
    }

}

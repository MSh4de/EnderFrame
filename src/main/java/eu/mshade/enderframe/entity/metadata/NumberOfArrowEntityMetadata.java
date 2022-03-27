package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class NumberOfArrowEntityMetadata extends EntityMetadata<Integer> {

    public NumberOfArrowEntityMetadata(Integer integer) {
        super(integer, EntityMetadataType.NUMBER_OF_ARROWS_IN_ENTITY);
    }

}

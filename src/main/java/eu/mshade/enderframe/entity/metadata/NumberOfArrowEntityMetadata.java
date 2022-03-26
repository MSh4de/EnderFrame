package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class NumberOfArrowEntityMetadata implements EntityMetadata<Integer> {

    private int numberOfArrow;

    @Override
    public void set(Integer integer) {
        this.numberOfArrow = integer;
    }

    @Override
    public Integer get() {
        return this.numberOfArrow;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.NUMBER_OF_ARROWS_IN_ENTITY;
    }
}

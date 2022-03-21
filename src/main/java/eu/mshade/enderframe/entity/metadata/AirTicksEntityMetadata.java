package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class AirTicksEntityMetadata implements EntityMetadata<Integer> {

    private int airTicks = 0;

    @Override
    public void set(Integer integer) {
        this.airTicks = integer;
    }

    @Override
    public Integer get() {
        return this.airTicks;
    }

    @Override
    public EntityMetadataType getEntityMetadataType() {
        return EntityMetadataType.AIR_TICKS;
    }
}

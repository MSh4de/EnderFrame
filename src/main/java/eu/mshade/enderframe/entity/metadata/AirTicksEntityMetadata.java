package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class AirTicksEntityMetadata extends EntityMetadataKeyValue<Integer> {

    public AirTicksEntityMetadata(Integer integer) {
        super(EntityMetadataKey.AIR_TICKS, integer);
    }

}
package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class AirTicksEntityMetadata extends MetadataKeyValue<Integer> {

    public AirTicksEntityMetadata(Integer integer) {
        super(EntityMetadataKey.AIR_TICKS, integer);
    }

}

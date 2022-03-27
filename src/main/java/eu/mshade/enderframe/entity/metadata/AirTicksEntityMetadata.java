package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class AirTicksEntityMetadata extends EntityMetadata<Integer> {

    public AirTicksEntityMetadata(Integer integer) {
        super(integer, EntityMetadataType.AIR_TICKS);
    }

}

package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKeyValue;

public class ScoreEntityMetadata extends EntityMetadataKeyValue<Integer> {

    public ScoreEntityMetadata(Integer integer) {
        super(EntityMetadataKey.SCORE, integer);
    }
}

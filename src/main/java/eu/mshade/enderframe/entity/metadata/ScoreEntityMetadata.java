package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;

public class ScoreEntityMetadata extends MetadataKeyValue<Integer> {

    public ScoreEntityMetadata(Integer integer) {
        super(EntityMetadataKey.SCORE, integer);
    }
}

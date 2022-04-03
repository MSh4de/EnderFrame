package eu.mshade.enderframe.entity.metadata;

import eu.mshade.enderframe.metadata.EntityMetadata;
import eu.mshade.enderframe.metadata.EntityMetadataType;

public class ScoreEntityMetadata extends EntityMetadata<Integer> {

    public ScoreEntityMetadata(Integer integer) {
        super(integer, EntityMetadataType.SCORE);
    }
}

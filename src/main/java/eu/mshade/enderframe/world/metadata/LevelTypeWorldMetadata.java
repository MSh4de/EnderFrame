package eu.mshade.enderframe.world.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.world.WorldMetadataType;
import eu.mshade.enderframe.world.LevelType;

public class LevelTypeWorldMetadata extends MetadataKeyValue<LevelType> {

    public LevelTypeWorldMetadata(LevelType metadataValue) {
        super(WorldMetadataType.LEVEL_TYPE, metadataValue);
    }
}

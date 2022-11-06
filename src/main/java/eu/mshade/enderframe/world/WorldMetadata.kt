package eu.mshade.enderframe.world

import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue


object WorldMetadataType {
    @JvmField var NAME: MetadataKey = MetadataKey.from("WORLD_NAME")
    @JvmField var SEED: MetadataKey = MetadataKey.from("WORLD_SEED")
    @JvmField var LEVEL_TYPE: MetadataKey = MetadataKey.from("WORLD_LEVEL_TYPE")
    @JvmField var DIMENSION: MetadataKey = MetadataKey.from("WORLD_DIMENSION")
    @JvmField var DIFFICULTY: MetadataKey = MetadataKey.from("WORLD_DIFFICULTY")

    @JvmField var PARENT: MetadataKey = MetadataKey.from("WORLD_PARENT")
}

class SeedWorldMetadata(metadataValue: Long) : MetadataKeyValue<Long>(WorldMetadataType.SEED, metadataValue)

class NameWorldMetadata(metadataValue: String) : MetadataKeyValue<String>(WorldMetadataType.NAME, metadataValue)

class LevelTypeWorldMetadata(metadataValue: LevelType) : MetadataKeyValue<LevelType>(WorldMetadataType.LEVEL_TYPE, metadataValue)

class DimensionWorldMetadata(metadataValue: Dimension) : MetadataKeyValue<Dimension>(WorldMetadataType.DIMENSION, metadataValue)

class DifficultyWorldMetadata(metadataValue: Difficulty) : MetadataKeyValue<Difficulty>(WorldMetadataType.DIFFICULTY, metadataValue)

class ParentWorldMetadata(metadataValue: World?) : MetadataKeyValue<World>(WorldMetadataType.PARENT, metadataValue)

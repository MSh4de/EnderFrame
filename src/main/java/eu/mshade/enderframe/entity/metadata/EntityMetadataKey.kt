package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKey

object EntityMetadataKey {

    //Register all entity metadata from 1.19
    val IS_ON_FIRE: MetadataKey = MetadataKey.from("ENTITY_IS_ON_FIRE")
    val IS_SNEAKING: MetadataKey = MetadataKey.from("ENTITY_IS_SNEAKING")
    val IS_SPRINTING: MetadataKey = MetadataKey.from("ENTITY_IS_SPRINTING")
    val IS_SWIMMING: MetadataKey = MetadataKey.from("ENTITY_IS_SWIMMING")
    val IS_INVISIBLE: MetadataKey = MetadataKey.from("ENTITY_IS_INVISIBLE")
    val IS_GLOWING: MetadataKey = MetadataKey.from("ENTITY_IS_GLOWING")
    val IS_FLYING: MetadataKey = MetadataKey.from("ENTITY_IS_FLYING")
    val AGE: MetadataKey = MetadataKey.from("ENTITY_AGE")
    val AGE_LOCKED: MetadataKey = MetadataKey.from("ENTITY_AGE_LOCKED")
    val BREEDABLE: MetadataKey = MetadataKey.from("ENTITY_BREEDABLE")
    val IS_SITTING: MetadataKey = MetadataKey.from("ENTITY_IS_SITTING")
    val IS_TAMED: MetadataKey = MetadataKey.from("ENTITY_IS_TAMED")
    val OWNER: MetadataKey = MetadataKey.from("ENTITY_OWNER")
    val IS_SHEARED: MetadataKey = MetadataKey.from("ENTITY_IS_SHEARED")
    val SADDLE: MetadataKey = MetadataKey.from("ENTITY_SADDLE")

    val SPRINTING: MetadataKey = MetadataKey.from("ENTITY_SPRINTING")

    val FLYING: MetadataKey = MetadataKey.from("ENTITY_FLYING")
}
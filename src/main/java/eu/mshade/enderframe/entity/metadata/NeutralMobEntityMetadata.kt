package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue

//Spider
class ClimbingEntityMetadata(screaming: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SCREAMING, screaming)


//Golem
class IsPlayerCreatedEntityMetadata(isPlayerCreated: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_PLAYER_CREATED, isPlayerCreated)


//Wolf
class IsAngryEntityMetadata(isAngry: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_ANGRY, isAngry)

class BeggingEntityMetadata(begging: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.BEGGING, begging)

class CollarColorEntityMetadata(collarColor: Int): MetadataKeyValue<Int>(EntityMetadataKey.COLLAR_COLOR, collarColor)


//Enderman
class IsScreamingEntityMetadata(isScreaming: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SCREAMING, isScreaming)
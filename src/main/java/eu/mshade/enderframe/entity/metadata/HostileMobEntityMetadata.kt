package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue

//Zombie
class IsVillagerEntityMetadata(villager: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_VILLAGER, villager)

class IsConvertingEntityMetadata(converting: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_CONVERTING, converting)


//Ghast
class IsAttackingEntityMetadata(attacking: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_ATTACKING, attacking)


//Guardian
class TargetIdEntityMetadata(targetId: Int): MetadataKeyValue<Int>(EntityMetadataKey.TARGET_ENTITY_ID, targetId)

class IsElderlyEntityMetadata(elderly: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_ELDERLY, elderly)

class IsRetractingSpikesEntityMetadata(retracting: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_RETRACTING_SPIKES, retracting)


//Slime
class SizeEntityMetadata(size: Int): MetadataKeyValue<Int>(EntityMetadataKey.SIZE, size)


//Witch
class IsAggressiveEntityMetadata(aggressive: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_AGGRESSIVE, aggressive)


//Creeper
class CreeperStateEntityMetadata(state: Int): MetadataKeyValue<Int>(EntityMetadataKey.CREEPER_STATE, state)

package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue
import java.util.UUID

//All the class representing Entity Metadata like crouching, sneaking, etc.
class IsOnFireEntityMetadata(isOnFire: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_ON_FIRE, isOnFire)

class IsSneakingEntityMetadata(isSneaking: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_SNEAKING, isSneaking)

class IsSprintingEntityMetadata(isSprinting: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_SPRINTING, isSprinting)

class IsSwimmingEntityMetadata(isSwimming: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_SWIMMING, isSwimming)

class IsInvisibleEntityMetadata(isInvisible: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_INVISIBLE, isInvisible)

class IsGlowingEntityMetadata(isGlowing: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_GLOWING, isGlowing)

class IsFlyingEntityMetadata(isFlying: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_FLYING, isFlying)

class AgeEntityMetadata(age: Int): MetadataKeyValue<Int>(EntityMetadataKey.AGE, age)

class AgeLockedEntityMetadata(ageLocked: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.AGE_LOCKED, ageLocked)

class BreedableEntityMetadata(breedable: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.BREEDABLE, breedable)

class IsSittingEntityMetadata(isSitting: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_SITTING, isSitting)

class IsTamedEntityMetadata(isTamed: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_TAMED, isTamed)

class OwnerEntityMetadata(owner: UUID?): MetadataKeyValue<UUID>(EntityMetadataKey.OWNER, owner)

class IsShearedEntityMetadata(isSheared: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_SHEARED, isSheared)

class SaddleEntityMetadata(saddle: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SADDLE, saddle)
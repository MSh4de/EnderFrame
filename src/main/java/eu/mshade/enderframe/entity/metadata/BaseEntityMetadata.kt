package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue
import java.util.UUID

//All the class representing Entity Metadata like crouching, sneaking, etc.
class OnFireEntityMetadata(onFire: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.ON_FIRE, onFire)

class SneakingEntityMetadata(sneaking: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SNEAKING, sneaking)

class SprintingEntityMetadata(sprinting: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SPRINTING, sprinting)

class SwimmingEntityMetadata(swimming: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SWIMMING, swimming)

class InvisibleEntityMetadata(invisible: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.INVISIBLE, invisible)

class GlowingEntityMetadata(glowing: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.GLOWING, glowing)

class FlyingEntityMetadata(flying: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.FLYING, flying)

class CrouchedEntityMetadata(crouched: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.CROUCHED, crouched)

class HandlingEntityMetadata(handling: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.HANDLING, handling)

class AgeEntityMetadata(age: Int): MetadataKeyValue<Int>(EntityMetadataKey.AGE, age)

class AgeLockedEntityMetadata(ageLocked: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.AGE_LOCKED, ageLocked)

class BreedableEntityMetadata(breedable: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.BREEDABLE, breedable)

class SittingEntityMetadata(sitting: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SITTING, sitting)

class TamedEntityMetadata(tamed: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.TAMED, tamed)

class OwnerEntityMetadata(owner: UUID): MetadataKeyValue<UUID>(EntityMetadataKey.OWNER, owner)

class ShearedEntityMetadata(sheared: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SHEARED, sheared)

class SaddleEntityMetadata(saddle: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SADDLE, saddle)
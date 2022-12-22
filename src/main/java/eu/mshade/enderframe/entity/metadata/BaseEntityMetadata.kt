package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue

//Basic
class VariantEntityMetadata(id: Int): MetadataKeyValue<Int>(EntityMetadataKey.VARIANT, id)

class FlyingEntityMetadata(flying: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.FLYING, flying)

class OwnerEntityMetadata(uuid: String): MetadataKeyValue<String>(EntityMetadataKey.OWNER, uuid)

class HasSaddleEntityMetadata(hasSaddle: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SADDLE, hasSaddle)

class IsPoweredEntityMetadata(powered: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.IS_POWERED, powered)


//Entity
class OnFireEntityMetadata(onFire: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.ON_FIRE, onFire)

class CrouchedEntityMetadata(crouched: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.CROUCHED, crouched)

class SprintingEntityMetadata(sprinting: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SPRINTING, sprinting)

class EatingEntityMetadata(eating: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.EATING, eating)

class HandlingEntityMetadata(handling: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.HANDLING, handling)

class InvisibleEntityMetadata(invisible: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.INVISIBLE, invisible)

class AirTicksEntityMetadata(airTicks: Int): MetadataKeyValue<Int>(EntityMetadataKey.AIR_TICKS, airTicks)


//Living Entity
class CustomNameEntityMetadata(name: String) : MetadataKeyValue<String>(EntityMetadataKey.CUSTOM_NAME, name)

class CustomNameVisibleEntityMetadata(visible: Boolean) : MetadataKeyValue<Boolean>(EntityMetadataKey.CUSTOM_NAME_VISIBLE, visible)

class HealthEntityMetadata(health: Float) : MetadataKeyValue<Float>(EntityMetadataKey.HEALTH, health)

class PotionEffectColorEntityMetadata(color: Int) : MetadataKeyValue<Int>(EntityMetadataKey.POTION_EFFECT_COLOR, color)

class PotionEffectAmbientEntityMetadata(ambient: Boolean) : MetadataKeyValue<Boolean>(EntityMetadataKey.POTION_EFFECT_AMBIENT, ambient)

class NumberOfArrowsInEntityEntityMetadata(numberOfArrows: Int) : MetadataKeyValue<Int>(EntityMetadataKey.NUMBER_OF_ARROWS_IN_ENTITY, numberOfArrows)

class WhetherArtificialIntelligenceEntityMetadata(artificialIntelligence: Boolean) : MetadataKeyValue<Boolean>(EntityMetadataKey.WHETHER_ARTIFICIAL_INTELLIGENCE, artificialIntelligence)
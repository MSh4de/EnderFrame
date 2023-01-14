package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue

//ArmorStand
class SmallArmorStandEntityMetadata(small: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SMALL_ARMOR_STAND, small)

class GravityEntityMetadata(gravity: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.GRAVITY, gravity)

class ArmsEntityMetadata(arms: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.ARMS, arms)

class RemoveBasePlateEntityMetadata(removeBasePlate: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.REMOVE_BASE_PLATE, removeBasePlate)

class MarkerEntityMetadata(marker: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.MARKER, marker)

class HeadRotationEntityMetadata(headRotation: Float): MetadataKeyValue<Float>(EntityMetadataKey.HEAD_ROTATION, headRotation)

class BodyRotationEntityMetadata(bodyRotation: Float): MetadataKeyValue<Float>(EntityMetadataKey.BODY_ROTATION, bodyRotation)

class LeftArmRotationEntityMetadata(leftArmRotation: Float): MetadataKeyValue<Float>(EntityMetadataKey.LEFT_ARM_ROTATION, leftArmRotation)

class RightArmRotationEntityMetadata(rightArmRotation: Float): MetadataKeyValue<Float>(EntityMetadataKey.RIGHT_ARM_ROTATION, rightArmRotation)

class LeftLegRotationEntityMetadata(leftLegRotation: Float): MetadataKeyValue<Float>(EntityMetadataKey.LEFT_LEG_ROTATION, leftLegRotation)

class RightLegRotationEntityMetadata(rightLegRotation: Float): MetadataKeyValue<Float>(EntityMetadataKey.RIGHT_LEG_ROTATION, rightLegRotation)


//Falling Block
class ItemEntityMetadata(item: Int): MetadataKeyValue<Int>(EntityMetadataKey.ITEM, item)


//Arrow
class CriticalEntityMetadata(critical: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.CRITICAL, critical)


//Boat
class TimeSinceLastHitEntityMetadata(timeSinceLastHit: Int): MetadataKeyValue<Int>(EntityMetadataKey.TIME_SINCE_LAST_HIT, timeSinceLastHit)

class ForwardDirectionEntityMetadata(forwardDirection: Int): MetadataKeyValue<Int>(EntityMetadataKey.FORWARD_DIRECTION, forwardDirection)

class DamageTakenEntityMetadata(damageTaken: Float): MetadataKeyValue<Float>(EntityMetadataKey.DAMAGE_TAKEN, damageTaken)
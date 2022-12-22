package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue

//Bat
class IsHangingEntityMetadata(isHanging: Int): MetadataKeyValue<Int>(EntityMetadataKey.IS_HANGING, isHanging)


//Sheep
class IsShearedEntityMetadata(isSheared: Int): MetadataKeyValue<Int>(EntityMetadataKey.IS_SHEARED, isSheared)

class ColorEntityMetadata(color: Int): MetadataKeyValue<Int>(EntityMetadataKey.COLOR, color)


//Horse
class StyleEntityMetadata(style: Int): MetadataKeyValue<Int>(EntityMetadataKey.STYLE, style)

class HasChestEntityMetadata(hasChest: Int): MetadataKeyValue<Int>(EntityMetadataKey.HAS_CHEST, hasChest)

class IsBredEntityMetadata(isBred: Int): MetadataKeyValue<Int>(EntityMetadataKey.IS_BRED, isBred)

class IsRearingEntityMetadata(isRearing: Int): MetadataKeyValue<Int>(EntityMetadataKey.IS_REARING, isRearing)

class MouthOpenEntityMetadata(mouthOpen: Int): MetadataKeyValue<Int>(EntityMetadataKey.MOUTH_OPEN, mouthOpen)

class HorseColorEntityMetadata(horseColor: Int): MetadataKeyValue<Int>(EntityMetadataKey.HORSE_COLOR, horseColor)

class ArmorEntityMetadata(armor: Int): MetadataKeyValue<Int>(EntityMetadataKey.ARMOR, armor)
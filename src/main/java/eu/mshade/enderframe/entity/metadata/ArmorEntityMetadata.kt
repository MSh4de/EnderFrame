package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue

class SmallArmorStandEntityMetadata(small: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.ON_FIRE, small)

class GravityEntityMetadata(gravity: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.GRAVITY, gravity)

class ArmsEntityMetadata(arms: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.ARMS, arms)

class BasePlateEntityMetadata(basePlate: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.BASE_PLATE, basePlate)

class MarkerEntityMetadata(marker: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.MARKER, marker)
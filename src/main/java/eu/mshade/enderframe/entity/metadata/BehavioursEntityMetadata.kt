package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue

//Ageable
class AgeEntityMetadata(age: Int): MetadataKeyValue<Int>(EntityMetadataKey.AGE, age)

class AgeLockedEntityMetadata(ageLocked: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.AGE_LOCKED, ageLocked)

class ChildEntityMetadata(child: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.CHILD, child)


//Tameable
class TamedEntityMetadata(tamed: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.TAMED, tamed)

class SittingEntityMetadata(sitting: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.SITTING, sitting)
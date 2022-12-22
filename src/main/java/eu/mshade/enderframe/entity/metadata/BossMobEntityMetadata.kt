package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue

//Wither
class InvulnerableTime(time: Int): MetadataKeyValue<Int>(EntityMetadataKey.INVULNERABLE_TIME, time)
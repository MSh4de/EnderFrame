package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.mojang.SkinPart

class SkinPartEntityMetadata(skinPart: SkinPart): MetadataKeyValue<SkinPart>(EntityMetadataKey.SKIN_PART, skinPart)
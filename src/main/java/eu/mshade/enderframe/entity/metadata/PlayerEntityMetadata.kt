package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.mojang.SkinPart

class SkinPartEntityMetadata(skinPart: SkinPart): MetadataKeyValue<SkinPart>(EntityMetadataKey.SKIN_PART, skinPart)

class HideCapEntityMetadata(hideCap: Boolean): MetadataKeyValue<Boolean>(EntityMetadataKey.HIDE_CAPE, hideCap)

class AdditionalHeartsEntityMetadata(additionalHearts: Float): MetadataKeyValue<Float>(EntityMetadataKey.ADDITIONAL_HEARTS, additionalHearts)

class ScoreEntityMetadata(score: Int): MetadataKeyValue<Int>(EntityMetadataKey.SCORE, score)
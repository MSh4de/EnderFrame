package eu.mshade.enderframe.item

import eu.mshade.enderframe.mojang.Color

data class FireworkExplosion(val flicker: Boolean = false, val trail: Boolean = false, val type: FireworkType, val color: Color, val fadeColor: Color?)
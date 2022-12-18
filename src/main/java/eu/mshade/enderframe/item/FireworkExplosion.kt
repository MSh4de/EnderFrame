package eu.mshade.enderframe.item

data class FireworkExplosion(val flicker: Boolean?, val trail: Boolean?, val type: FireworkType, val colors: IntArray, val fadeColors: IntArray?) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FireworkExplosion

        if (flicker != other.flicker) return false
        if (trail != other.trail) return false
        if (type != other.type) return false
        if (!colors.contentEquals(other.colors)) return false
        if (fadeColors != null) {
            if (other.fadeColors == null) return false
            if (!fadeColors.contentEquals(other.fadeColors)) return false
        } else if (other.fadeColors != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = flicker?.hashCode() ?: 0
        result = 31 * result + (trail?.hashCode() ?: 0)
        result = 31 * result + type.hashCode()
        result = 31 * result + colors.contentHashCode()
        result = 31 * result + (fadeColors?.contentHashCode() ?: 0)
        return result
    }
}
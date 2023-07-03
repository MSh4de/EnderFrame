package eu.mshade.enderframe.attribute

interface AttributeKey {

    val name: String
    val defaultValue: Double
    val minValue: Double
    val maxValue: Double

    companion object {
        @JvmStatic
        fun from(name: String, defaultValue: Double, minValue: Double, maxValue: Double): AttributeKey? {
            return DefaultAttributeKey(name, defaultValue, minValue, maxValue)
        }

        @JvmStatic
        fun from(name: String, defaultValue: Double, maxValue: Double): AttributeKey? {
            return from(name, defaultValue, 0.0, maxValue)
        }
    }
}

data class DefaultAttributeKey(
    override val name: String,
    override val defaultValue: Double,
    override val minValue: Double,
    override val maxValue: Double
) : AttributeKey

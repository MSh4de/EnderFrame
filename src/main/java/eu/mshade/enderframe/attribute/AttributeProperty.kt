package eu.mshade.enderframe.attribute

class AttributeProperty(val attribute: AttributeKey, val value: Double) {

    private val attributeModifiers = mutableListOf<AttributeModifier>()

    fun addAttributeModifier(attributeModifier: AttributeModifier): AttributeProperty {
        attributeModifiers.add(attributeModifier)
        return this
    }

    fun getAttributeModifiers(): List<AttributeModifier> {
        return attributeModifiers
    }

}

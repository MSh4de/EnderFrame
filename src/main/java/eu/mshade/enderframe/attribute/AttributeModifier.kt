package eu.mshade.enderframe.attribute

import java.util.*

class AttributeModifier(val uuid: UUID, var amount: Double, val attributeOperation: AttributeOperation) {

    constructor(amount: Double, attributeOperation: AttributeOperation) : this(
        UUID.randomUUID(),
        amount,
        attributeOperation
    )
}

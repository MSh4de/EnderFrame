package eu.mshade.enderframe.metadata.attribute;

import java.util.UUID;

public class AttributeModifier {

    private final UUID uuid;
    private final double amount;
    private final AttributeOperation attributeOperation;

    public AttributeModifier(UUID uuid, double amount, AttributeOperation attributeOperation) {

        this.uuid = uuid;
        this.amount = amount;
        this.attributeOperation = attributeOperation;
    }


    public UUID getUuid() {
        return this.uuid;
    }

    public double getAmount() {
        return this.amount;
    }

    public AttributeOperation getAttributeOperation() {
        return this.attributeOperation;
    }
}

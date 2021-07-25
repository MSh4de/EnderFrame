package eu.mshade.enderframe.metadata.attribute;

import java.util.UUID;

public class AttributeModifier {

    private final String name;
    private final UUID uuid;
    private final double amount;
    private final byte operation;

    public AttributeModifier(String name, UUID uuid, double amount, byte operation) {
        this.name = name;
        this.uuid = uuid;
        this.amount = amount;
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public double getAmount() {
        return amount;
    }

    public byte getOperation() {
        return operation;
    }
}

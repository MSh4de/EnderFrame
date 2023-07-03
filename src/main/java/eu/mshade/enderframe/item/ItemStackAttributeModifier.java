package eu.mshade.enderframe.item;

import eu.mshade.enderframe.inventory.EquipmentSlot;
import eu.mshade.enderframe.attribute.AttributeKey;
import eu.mshade.enderframe.attribute.AttributeModifier;

public class ItemStackAttributeModifier {

    private AttributeKey attributeKey;
    private String name;
    private EquipmentSlot equipmentSlot;
    private AttributeModifier attributeModifier;

    public ItemStackAttributeModifier(AttributeKey attributeKey, String name, EquipmentSlot equipmentSlot, AttributeModifier attributeModifier) {
        this.attributeKey = attributeKey;
        this.name = name;
        this.equipmentSlot = equipmentSlot;
        this.attributeModifier = attributeModifier;
    }

    public AttributeKey getAttributeKey() {
        return attributeKey;
    }

    public String getName() {
        return name;
    }

    public EquipmentSlot getEquipmentSlot() {
        return equipmentSlot;
    }

    public AttributeModifier getAttributeModifier() {
        return attributeModifier;
    }
}

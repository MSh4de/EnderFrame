package eu.mshade.enderframe.metadata.attribute;

import java.util.ArrayList;
import java.util.List;

public class AttributeProperty {

    private final AttributeType attribute;
    private final double value;
    private final List<AttributeModifier> attributeModifiers = new ArrayList<>();

    public AttributeProperty(AttributeType attribute, double value) {
        this.attribute = attribute;
        this.value = value;
    }

    public AttributeProperty addAttributeModifier(AttributeModifier attributeModifier){
        this.attributeModifiers.add(attributeModifier);
        return this;
    }

    public AttributeType getAttribute() {
        return attribute;
    }

    public double getValue() {
        return value;
    }

    public List<AttributeModifier> getAttributeModifiers() {
        return attributeModifiers;
    }
}

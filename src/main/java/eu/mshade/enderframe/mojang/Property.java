package eu.mshade.enderframe.mojang;

import eu.mshade.mwork.MOptional;

import java.util.Objects;

public class Property {

    private String name;
    private String value;
    private String signature;

    private Property() {
    }

    public Property(String name, String value, String signature) {
        this.name = name;
        this.value = value;
        this.signature = signature;
    }

    public Property(String name, String value) {
        this(name, value, null);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(name, property.name) && Objects.equals(value, property.value) && Objects.equals(signature, property.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, signature);
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}

package eu.mshade.enderframe.mojang;

import eu.mshade.mwork.MOptional;

import java.util.Objects;

public class Property {

    private String name;
    private String value;
    private MOptional<String> signature;

    private Property() {
    }

    public Property(String name, String value, MOptional<String> signature) {
        this.name = name;
        this.value = value;
        this.signature = signature;
    }

    public Property(String name, String value) {
        this(name, value, MOptional.empty());
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public MOptional<String> getSignature() {
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
}

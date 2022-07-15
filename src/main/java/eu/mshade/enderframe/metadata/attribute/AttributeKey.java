package eu.mshade.enderframe.metadata.attribute;

public interface AttributeKey {

    String getName();

    double getDefaultValue();

    double getMinValue();

    double getMaxValue();

    static AttributeKey from(String name, double defaultValue, double minValue, double maxValue){
        return new DefaultAttributeKey(name, defaultValue, minValue, maxValue);
    }

    static AttributeKey from(String name, double defaultValue, double maxValue){
        return from(name, defaultValue, 0, maxValue);
    }

    class DefaultAttributeKey implements AttributeKey {

        private final String name;
        private final double defaultValue, minValue, maxValue;

        public DefaultAttributeKey(String name, double defaultValue, double minValue, double maxValue) {
            this.name = name;
            this.defaultValue = defaultValue;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public double getDefaultValue() {
            return this.defaultValue;
        }

        @Override
        public double getMinValue() {
            return this.minValue;
        }

        @Override
        public double getMaxValue() {
            return this.maxValue;
        }

        @Override
        public String toString() {
            return "DefaultAttributeKey{" +
                    "name='" + name + '\'' +
                    ", defaultValue=" + defaultValue +
                    ", minValue=" + minValue +
                    ", maxValue=" + maxValue +
                    '}';
        }
    }

}

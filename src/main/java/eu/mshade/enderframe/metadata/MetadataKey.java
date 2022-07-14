package eu.mshade.enderframe.metadata;

import java.util.Objects;

public interface MetadataKey {

    String getName();

    static MetadataKey from(String name){
        return new DefaultMetadataKey(name);
    }

    class DefaultMetadataKey implements MetadataKey {

        private String name;

        public DefaultMetadataKey(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof MetadataKey)) return false;
            MetadataKey metadataKey = (MetadataKey) o;
            return Objects.equals(this.name, metadataKey.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "DefaultMetadataKey{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}

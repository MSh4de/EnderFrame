package eu.mshade.enderframe.item;

import eu.mshade.enderframe.mojang.NamespacedKey;

import java.util.Objects;

public interface MaterialKey {

    int getId();

    int getMetadata();

    NamespacedKey getNamespacedKey();

    static MaterialKey from(int id, int data, NamespacedKey namespacedKey){
        return new MaterialData(id, data, namespacedKey);
    }

    static MaterialKey from(int id, int data){
        return new MaterialData(id, data, null);
    }


    static MaterialKey from(int id, NamespacedKey namespacedKey){
        return new MaterialData(id, 0, namespacedKey);
    }

    static MaterialKey from(int id){
        return new MaterialData(id, 0, null);
    }

    static MaterialKey fromWithOutMetadata(int id, NamespacedKey namespacedKey){
        return new DefaultMaterialKey(id, namespacedKey);
    }

    class MaterialData implements MaterialKey{

        private int id;
        private int metadata;
        private NamespacedKey namespacedKey;

        public MaterialData(int id, int metadata, NamespacedKey namespacedKey) {
            this.id = id;
            this.metadata = metadata;
            this.namespacedKey = namespacedKey;
        }

        @Override
        public int getId() {
            return this.id;
        }

        @Override
        public int getMetadata() {
            return this.metadata;
        }

        @Override
        public NamespacedKey getNamespacedKey() {
            return this.namespacedKey;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof MaterialKey)) return false;
            MaterialKey materialKey = (MaterialKey) o;
            return id == materialKey.getId() && metadata == materialKey.getMetadata();
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, metadata);
        }

        @Override
        public String toString() {
            return "MaterialData{" +
                    "id=" + id +
                    ", metadata=" + metadata +
                    ", namespacedKey=" + namespacedKey +
                    '}';
        }
    }

    class DefaultMaterialKey implements MaterialKey {

        private int id;
        private NamespacedKey namespacedKey;

        public DefaultMaterialKey(int id, NamespacedKey namespacedKey) {
            this.id = id;
            this.namespacedKey = namespacedKey;
        }

        @Override
        public int getId() {
            return this.id;
        }

        @Override
        public int getMetadata() {
            return 0;
        }

        @Override
        public NamespacedKey getNamespacedKey() {
            return this.namespacedKey;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof MaterialKey)) return false;
            MaterialKey materialKey = (MaterialKey) o;
            return id == materialKey.getId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

}

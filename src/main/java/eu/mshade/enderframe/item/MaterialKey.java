package eu.mshade.enderframe.item;

import eu.mshade.enderframe.mojang.NamespacedKey;

import java.util.*;

public interface MaterialKey {

    int getId();

    int getMetadata();

    NamespacedKey getNamespacedKey();

    Set<MaterialCategoryKey> getMaterialCategoryKeys();

    default boolean inMaterialCategoryKey(MaterialCategoryKey... materialCategoryKeys){
        for (MaterialCategoryKey materialCategoryKey : materialCategoryKeys) {
            if (getMaterialCategoryKeys().contains(materialCategoryKey)) return true;
        }
        return false;
    }

    default boolean inMaterialCategoryKey(Collection<MaterialCategoryKey> materialCategoryKeys){
        for (MaterialCategoryKey materialCategoryKey : materialCategoryKeys) {
            if (getMaterialCategoryKeys().contains(materialCategoryKey)) return true;
        }
        return false;
    }

    static MaterialKey from(int id, int data, NamespacedKey namespacedKey){
        return new DefaultMaterialKey(id, data, namespacedKey, new HashSet<>());
    }

    static MaterialKey from(int id, int data, NamespacedKey namespacedKey, Set<MaterialCategoryKey> materialCategoryKeys){
        return new DefaultMaterialKey(id, data, namespacedKey, materialCategoryKeys);
    }

    static MaterialKey from(int id, int data){
        return new DefaultMaterialKey(id, data, null, new HashSet<>());
    }

    static MaterialKey from(int id, int data, Set<MaterialCategoryKey> materialCategoryKeys){
        return new DefaultMaterialKey(id, data, null, materialCategoryKeys);
    }

    static MaterialKey from(int id, NamespacedKey namespacedKey){
        return new DefaultMaterialKey(id, 0, namespacedKey, new HashSet<>());
    }

    static MaterialKey from(int id, NamespacedKey namespacedKey, Set<MaterialCategoryKey> materialCategoryKeys){
        return new DefaultMaterialKey(id, 0, namespacedKey, materialCategoryKeys);
    }

    static MaterialKey from(int id){
        return new DefaultMaterialKey(id, 0, null, new HashSet<>());
    }

    static MaterialKey from(int id, Set<MaterialCategoryKey> materialCategoryKeys){
        return new DefaultMaterialKey(id, 0, null, materialCategoryKeys);
    }

    class DefaultMaterialKey implements MaterialKey{

        private int id;
        private int metadata;
        private NamespacedKey namespacedKey;
        private Set<MaterialCategoryKey> materialCategoryKeys;

        public DefaultMaterialKey(int id, int metadata, NamespacedKey namespacedKey, Set<MaterialCategoryKey> materialCategoryKeys) {
            this.id = id;
            this.metadata = metadata;
            this.namespacedKey = namespacedKey;
            this.materialCategoryKeys = materialCategoryKeys;
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
        public Set<MaterialCategoryKey> getMaterialCategoryKeys() {
            return this.materialCategoryKeys;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof MaterialKey materialKey)) return false;
            if (this == o) return true;
            return id == materialKey.getId() && metadata == materialKey.getMetadata();
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, metadata);
        }

        @Override
        public String toString() {
            return "DefaultMaterialKey{" +
                    "id=" + id +
                    ", metadata=" + metadata +
                    ", namespacedKey=" + namespacedKey +
                    ", materialCategoryKeys=" + materialCategoryKeys +
                    '}';
        }
    }

}

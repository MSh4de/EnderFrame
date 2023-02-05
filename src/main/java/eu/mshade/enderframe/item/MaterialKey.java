package eu.mshade.enderframe.item;

import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;
import eu.mshade.enderframe.mojang.NamespacedKey;
import eu.mshade.enderframe.world.block.Block;

import java.util.*;

public interface MaterialKey {

    int getId();

    int getMetadata();

    NamespacedKey getNamespacedKey();

    int getMaxStackSize();

    int getMaxDurability();

    Set<MaterialCategoryKey> getMaterialCategories();

    MaterialCategoryKey getTag();


    default boolean inMaterialCategories(MaterialCategoryKey... materialCategoryKeys) {
        for (MaterialCategoryKey materialCategoryKey : materialCategoryKeys) {
            if (getMaterialCategories().contains(materialCategoryKey)) return true;
        }
        return false;
    }

    default boolean inMaterialCategories(Collection<MaterialCategoryKey> materialCategoryKeys) {
        for (MaterialCategoryKey materialCategoryKey : materialCategoryKeys) {
            if (getMaterialCategories().contains(materialCategoryKey)) return true;
        }
        return false;
    }

    default Block toBlock() {
        return new Block(this, new MetadataKeyValueBucket());
    }

    static MaterialKey from(NamespacedKey namespacedKey, int maxStackSize, int maxDurability, Set<MaterialCategoryKey> materialCategoryKeys) {
        return new DefaultMaterialKey(-1, 0, namespacedKey, maxStackSize, maxDurability, MaterialCategory.DEFAULT, materialCategoryKeys);
    }

    static MaterialKey from(NamespacedKey namespacedKey, int maxStackSize, int maxDurability, MaterialCategoryKey tag, Set<MaterialCategoryKey> materialCategoryKeys) {
        return new DefaultMaterialKey(-1, 0, namespacedKey, maxStackSize, maxDurability, tag, materialCategoryKeys);
    }

    static MaterialKey from(NamespacedKey namespacedKey, int maxStackSize, Set<MaterialCategoryKey> materialCategoryKeys) {
        return from(namespacedKey, maxStackSize, -1, materialCategoryKeys);
    }

    static MaterialKey from(NamespacedKey namespacedKey, Set<MaterialCategoryKey> materialCategoryKeys) {
        return from(namespacedKey, -1, -1, materialCategoryKeys);
    }

    static MaterialKey from(int id, NamespacedKey namespacedKey, int maxStackSize, int maxDurability, Set<MaterialCategoryKey> materialCategoryKeys) {
        return new DefaultMaterialKey(id, 0, namespacedKey, maxStackSize, maxDurability, MaterialCategory.DEFAULT, materialCategoryKeys);
    }

    static MaterialKey from(int id, int data) {
        return new DefaultMaterialKey(id, data, null, -1, -1, MaterialCategory.DEFAULT, Set.of());
    }

    static MaterialKey from(int id) {
        return new DefaultMaterialKey(id, 0, null, -1, -1, MaterialCategory.DEFAULT, Set.of());
    }


    class DefaultMaterialKey implements MaterialKey {

        private int id;
        private int metadata;
        private NamespacedKey namespacedKey;
        private int maxStackSize;
        private int maxDurability;
        private Set<MaterialCategoryKey> materialCategoryKeys;
        private MaterialCategoryKey tag;

        public DefaultMaterialKey(int id, int metadata, NamespacedKey namespacedKey, int maxStackSize, int maxDurability, MaterialCategoryKey tag, Set<MaterialCategoryKey> materialCategoryKeys) {
            this.id = id;
            this.metadata = metadata;
            this.namespacedKey = namespacedKey;
            this.maxStackSize = maxStackSize;
            this.maxDurability = maxDurability;
            this.materialCategoryKeys = materialCategoryKeys;
            this.tag = tag;
        }

        @Override
        public int getId() {
            return this.id;
        }


        public DefaultMaterialKey setId(int id) {
            this.id = id;
            return this;
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
        public Set<MaterialCategoryKey> getMaterialCategories() {
            return this.materialCategoryKeys;
        }

        @Override
        public MaterialCategoryKey getTag() {
            return this.tag;
        }

        @Override
        public int getMaxStackSize() {
            return this.maxStackSize;
        }

        @Override
        public int getMaxDurability() {
            return this.maxDurability;
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
                    ", maxStackSize=" + maxStackSize +
                    ", namespacedKey=" + namespacedKey +
                    ", materialCategoryKeys=" + materialCategoryKeys +
                    '}';
        }
    }

}

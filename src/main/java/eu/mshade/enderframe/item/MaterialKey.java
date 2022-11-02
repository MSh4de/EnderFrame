package eu.mshade.enderframe.item;

import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;
import eu.mshade.enderframe.mojang.NamespacedKey;
import eu.mshade.enderframe.world.block.Block;

import java.util.*;

public interface MaterialKey {

    int getId();

    int getMetadata();

    NamespacedKey getNamespacedKey();

    MaterialCategoryKey getMaterialCategoryKey();

    Set<MaterialCategoryKey> getMaterialCategoryKeys();

    int getMaxStackSize();


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

    default Block toBlock(){
        return new Block(this, new MetadataKeyValueBucket());
    }

    static MaterialKey from(int id, int data, int maxStackSize, NamespacedKey namespacedKey, MaterialCategoryKey materialCategoryKey){
        return new DefaultMaterialKey(id, data, maxStackSize, namespacedKey, materialCategoryKey, new HashSet<>());
    }

    static MaterialKey from(int id, int data, int maxStackSize, NamespacedKey namespacedKey, MaterialCategoryKey materialCategoryKey, Set<MaterialCategoryKey> materialCategoryKeys){
        return new DefaultMaterialKey(id, data, maxStackSize, namespacedKey, materialCategoryKey, materialCategoryKeys);
    }

    static MaterialKey from(int id, int data){
        return new DefaultMaterialKey(id, data, -1,null, null, new HashSet<>());
    }

    static MaterialKey from(int id, int data, int maxStackSize, MaterialCategoryKey materialCategoryKey){
        return new DefaultMaterialKey(id, data, maxStackSize,null, materialCategoryKey, new HashSet<>());
    }

    static MaterialKey from(int id, int data, MaterialCategoryKey materialCategoryKey, Set<MaterialCategoryKey> materialCategoryKeys){
        return new DefaultMaterialKey(id, data, -1, null, materialCategoryKey, materialCategoryKeys);
    }

    static MaterialKey from(int id, int data, int maxStackSize, MaterialCategoryKey materialCategoryKey, Set<MaterialCategoryKey> materialCategoryKeys){
        return new DefaultMaterialKey(id, data, maxStackSize, null, materialCategoryKey, materialCategoryKeys);
    }

    static MaterialKey from(int id, NamespacedKey namespacedKey, MaterialCategoryKey materialCategoryKey){
        return new DefaultMaterialKey(id, 0, -1, namespacedKey, materialCategoryKey, new HashSet<>());
    }

    static MaterialKey from(int id, int maxStackSize,  NamespacedKey namespacedKey, MaterialCategoryKey materialCategoryKey){
        return new DefaultMaterialKey(id, 0, maxStackSize, namespacedKey, materialCategoryKey, new HashSet<>());
    }

    static MaterialKey from(int id, int maxStackSize, NamespacedKey namespacedKey, MaterialCategoryKey materialCategoryKey, Set<MaterialCategoryKey> materialCategoryKeys){
        return new DefaultMaterialKey(id, 0, maxStackSize, namespacedKey, materialCategoryKey, materialCategoryKeys);
    }

    static MaterialKey from(int id, NamespacedKey namespacedKey, MaterialCategoryKey materialCategoryKey, Set<MaterialCategoryKey> materialCategoryKeys){
        return new DefaultMaterialKey(id, 0, -1, namespacedKey, materialCategoryKey, materialCategoryKeys);
    }

    static MaterialKey from(int id){
        return new DefaultMaterialKey(id, 0, -1, null, null, new HashSet<>());
    }

    static MaterialKey from(int id, MaterialCategoryKey materialCategoryKey, Set<MaterialCategoryKey> materialCategoryKeys){
        return new DefaultMaterialKey(id, 0, -1,null, materialCategoryKey, materialCategoryKeys);
    }

    class DefaultMaterialKey implements MaterialKey{

        private int id;
        private int metadata;
        private int maxStackSize;
        private NamespacedKey namespacedKey;
        private MaterialCategoryKey materialCategoryKey;
        private Set<MaterialCategoryKey> materialCategoryKeys;

        public DefaultMaterialKey(int id, int metadata, int maxStackSize, NamespacedKey namespacedKey, MaterialCategoryKey materialCategoryKey, Set<MaterialCategoryKey> materialCategoryKeys) {
            this.id = id;
            this.metadata = metadata;
            this.maxStackSize = maxStackSize;
            this.namespacedKey = namespacedKey;
            this.materialCategoryKey = materialCategoryKey;
            this.materialCategoryKeys = materialCategoryKeys;
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
        public MaterialCategoryKey getMaterialCategoryKey() {
            return this.materialCategoryKey;
        }

        @Override
        public Set<MaterialCategoryKey> getMaterialCategoryKeys() {
            return this.materialCategoryKeys;
        }

        @Override
        public int getMaxStackSize() {
            return this.maxStackSize;
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
                    ", materialCategoryKey=" + materialCategoryKey +
                    ", materialCategoryKeys=" + materialCategoryKeys +
                    '}';
        }
    }

}

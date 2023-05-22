package eu.mshade.enderframe.item;

import eu.mshade.enderframe.inventory.EquipmentSlot;
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;
import eu.mshade.enderframe.mojang.NamespacedKey;
import eu.mshade.enderframe.world.block.Block;

import java.util.*;

public interface MaterialKey {


    static MaterialKey from(NamespacedKey namespacedKey, int maxStackSize, int maxDurability, float hardness, float blastResistance, float slipperiness, Set<MaterialTagKey> materialTagKeys) {
        return from(namespacedKey, maxStackSize, maxDurability, hardness, blastResistance, slipperiness, null, materialTagKeys);
    }

    static MaterialKey from(NamespacedKey namespacedKey, int maxStackSize, int maxDurability, float hardness, float blastResistance, float slipperiness, EquipmentSlot equipmentSlot, Set<MaterialTagKey> materialTagKeys) {
        return from(0, 0, namespacedKey, maxStackSize, maxDurability, hardness, blastResistance, slipperiness, equipmentSlot, materialTagKeys);
    }

    static MaterialKey from(int id, NamespacedKey namespacedKey, int maxStackSize, int maxDurability, Set<MaterialTagKey> materialTagKeys) {
        return from(id, 0, namespacedKey, maxStackSize, maxDurability, 0, 0, 0, null, materialTagKeys);
    }

    static MaterialKey from(int id) {
        return from(id, 0);
    }

    static MaterialKey from(int id, int data) {
        return from(id, data, null, 0, 0, 0, 0, 0, null, Set.of());
    }

    static MaterialKey from(int id, int data, NamespacedKey namespacedKey, int maxStackSize, int maxDurability, float hardness, float blastResistance, float slipperiness, EquipmentSlot equipmentSlot, Set<MaterialTagKey> materialTagKeys) {
        return new DefaultMaterialKey(id, data, namespacedKey, maxStackSize, maxDurability, hardness, blastResistance, slipperiness, equipmentSlot, materialTagKeys);
    }

    int getId();

    int getMetadata();

    NamespacedKey getNamespacedKey();

    int getMaxStackSize();

    int getMaxDurability();

    float getHardness();

    float getBlastResistance();

    float getSlipperiness();

    EquipmentSlot getEquipmentSlot();

    Set<MaterialTagKey> getMaterialCategories();

    default boolean inMaterialCategories(MaterialTagKey... materialTagKeys) {
        for (MaterialTagKey materialTagKey : materialTagKeys) {
            if (getMaterialCategories().contains(materialTagKey)) return true;
        }
        return false;
    }

    default boolean inMaterialCategories(Collection<MaterialTagKey> materialTagKeys) {
        for (MaterialTagKey materialTagKey : materialTagKeys) {
            if (getMaterialCategories().contains(materialTagKey)) return true;
        }
        return false;
    }

    default Block toBlock() {
        return new Block(this, new MetadataKeyValueBucket());
    }

    class DefaultMaterialKey implements MaterialKey {

        private int id;
        private int metadata;
        private NamespacedKey namespacedKey;
        private int maxStackSize;
        private int maxDurability;
        private float hardness;
        private float blastResistance;
        private float slipperiness;
        private EquipmentSlot equipmentSlot;
        private Set<MaterialTagKey> materialCategories;

        public DefaultMaterialKey(int id, int metadata, NamespacedKey namespacedKey, int maxStackSize, int maxDurability, float hardness, float blastResistance, float slipperiness, EquipmentSlot equipmentSlot, Set<MaterialTagKey> materialCategories) {
            this.id = id;
            this.metadata = metadata;
            this.namespacedKey = namespacedKey;
            this.maxStackSize = maxStackSize;
            this.maxDurability = maxDurability;
            this.hardness = hardness;
            this.blastResistance = blastResistance;
            this.slipperiness = slipperiness;
            this.equipmentSlot = equipmentSlot;
            this.materialCategories = materialCategories;
        }

        @Override
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public int getMetadata() {
            return metadata;
        }

        @Override
        public NamespacedKey getNamespacedKey() {
            return namespacedKey;
        }

        @Override
        public int getMaxStackSize() {
            return maxStackSize;
        }

        @Override
        public int getMaxDurability() {
            return maxDurability;
        }

        @Override
        public float getHardness() {
            return hardness;
        }

        @Override
        public float getBlastResistance() {
            return blastResistance;
        }

        @Override
        public float getSlipperiness() {
            return slipperiness;
        }

        @Override
        public EquipmentSlot getEquipmentSlot() {
            return equipmentSlot;
        }

        @Override
        public Set<MaterialTagKey> getMaterialCategories() {
            return materialCategories;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DefaultMaterialKey that)) return false;
            return id == that.id && metadata == that.metadata && maxStackSize == that.maxStackSize && maxDurability == that.maxDurability && Float.compare(that.hardness, hardness) == 0 && Float.compare(that.blastResistance, blastResistance) == 0 && Float.compare(that.slipperiness, slipperiness) == 0 && Objects.equals(namespacedKey, that.namespacedKey) && equipmentSlot == that.equipmentSlot && Objects.equals(materialCategories, that.materialCategories);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, metadata, namespacedKey, maxStackSize, maxDurability, hardness, blastResistance, slipperiness, equipmentSlot, materialCategories);
        }

        @Override
        public String toString() {
            return "DefaultMaterialKey{" +
                    "id=" + id +
                    ", metadata=" + metadata +
                    ", namespacedKey=" + namespacedKey +
                    ", maxStackSize=" + maxStackSize +
                    ", maxDurability=" + maxDurability +
                    ", hardness=" + hardness +
                    ", blastResistance=" + blastResistance +
                    ", slipperiness=" + slipperiness +
                    ", equipmentSlot=" + equipmentSlot +
                    ", materialCategories=" + materialCategories +
                    '}';
        }
    }

}

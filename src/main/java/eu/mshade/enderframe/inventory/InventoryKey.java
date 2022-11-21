package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.mojang.NamespacedKey;

import java.util.Objects;

public interface InventoryKey {

    int getId();

    String getName();

    int getDefaultSlot();

    static InventoryKey from(int id, String name, int slot){
        return new DefaultInventoryKey(id, name, slot);
    }

    static InventoryKey from(int id, NamespacedKey namespacedKey, int slot){
        return new DefaultInventoryKey(id, namespacedKey.toString(), slot);
    }

    static InventoryKey from(int id, String name){
        return new DefaultInventoryKey(id, name, -1);
    }

    class DefaultInventoryKey implements InventoryKey{

        private String name;
        private int slot;
        private int id;

        public DefaultInventoryKey(int id, String name, int slot) {
            this.name = name;
            this.id = id;
            this.slot = slot;
        }

        @Override
        public int getId() {
            return this.id;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public int getDefaultSlot() {
            return this.slot;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if(!(o instanceof InventoryKey)) return false;
            InventoryKey inventoryKey = (InventoryKey) o;
            return Objects.equals(name, inventoryKey.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "DefaultInventoryKey{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}

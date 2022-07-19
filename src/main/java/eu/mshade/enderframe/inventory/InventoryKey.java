package eu.mshade.enderframe.inventory;

import java.util.Objects;

public interface InventoryKey {

    String getName();

    int getDefaultSlot();

    static InventoryKey from(String name, int slot){
        return new DefaultInventoryKey(name, slot);
    }

    static InventoryKey from(String name){
        return new DefaultInventoryKey(name, -1);
    }

    class DefaultInventoryKey implements InventoryKey{

        private String name;
        private int slot;

        public DefaultInventoryKey(String name, int slot) {
            this.name = name;
            this.slot = slot;
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

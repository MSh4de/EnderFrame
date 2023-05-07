package eu.mshade.enderframe.inventory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class InventoryType {

    private static final Map<Integer, InventoryKey> INVENTORY_TYPE_BY_ID = new HashMap<>();

    public static InventoryKey CHEST = InventoryKey.from(0, "CHEST", 9 * 3);
    public static InventoryKey HOPPER = InventoryKey.from(1, "HOPPER", 5);
    public static InventoryKey PLAYER = InventoryKey.from(2, "PLAYER", 46);
    public static InventoryKey WORKBENCH = InventoryKey.from(3, "WORKBENCH", 3 * 3);
    public static InventoryKey FURNACE = InventoryKey.from(4, "FURNACE", 3);
    public static InventoryKey DISPENSER = InventoryKey.from(5, "DISPENSER", 3 * 3);
    public static InventoryKey ENCHANTMENT_TABLE = InventoryKey.from(6, "ENCHANTMENT_TABLE", 2);
    public static InventoryKey BREWING_STAND = InventoryKey.from(7, "BREWING_STAND", 4);
    public static InventoryKey VILLAGER = InventoryKey.from(8, "VILLAGER", 4);
    public static InventoryKey BEACON = InventoryKey.from(9, "BEACON", 4);
    public static InventoryKey ANVIL = InventoryKey.from(10, "ANVIL", 3);


    static {
        try {
            for (Field field : InventoryType.class.getDeclaredFields()) {
                Object o = field.get(null);
                if (o instanceof InventoryKey inventoryKey) {
                    register(inventoryKey);
                }

            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static InventoryKey fromId(int id) {
        return INVENTORY_TYPE_BY_ID.get(id);
    }

    public static void register(InventoryKey inventoryKey){
        INVENTORY_TYPE_BY_ID.put(inventoryKey.getId(), inventoryKey);
    }


}
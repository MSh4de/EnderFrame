package eu.mshade.enderframe.inventory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InventoryRepository {

    protected Map<Integer, Inventory> inventoryById = new ConcurrentHashMap<>();

    public void register(Inventory inventory){
        this.inventoryById.put(inventory.getId(), inventory);
    }

    public void flush(Inventory inventory){
        this.inventoryById.remove(inventory.getId());
        Inventory.UNIQUE_ID_MANAGER.flushId(inventory.getId());
    }
}

package eu.mshade.enderframe.inventory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryRepository {

    protected Map<Inventory, Integer> idByInventory = new ConcurrentHashMap<>();
    private Map<Integer, Inventory> inventoryById = new ConcurrentHashMap<>();

    public int getIdOfInventory(Inventory inventory){
        return this.idByInventory.get(inventory);
    }

    public Inventory getInventory(int id){
        return this.inventoryById.get(id);
    }

    public void register(int id, Inventory inventory){
        this.inventoryById.put(id, inventory);
        this.idByInventory.put(inventory, id);
    }

    public void flush(Inventory inventory){
        int id = this.idByInventory.remove(inventory);
        this.inventoryById.remove(id);
    }
}
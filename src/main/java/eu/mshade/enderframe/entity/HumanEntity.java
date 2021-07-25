package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.GameMode;
import eu.mshade.enderframe.item.ItemStack;

public interface HumanEntity extends LivingEntity {

    String getName();

    //PlayerInventory getInventory();

    //Inventory getEnderChest();

    //boolean setWindowProperty(InventoryView.Property prop, int value);

    //InventoryView getOpenInventory();

    //InventoryView openInventory(Inventory inventory);

    //InventoryView openWorkbench(Location location, boolean force);

    //InventoryView openEnchanting(Location location, boolean force);

    //void openInventory(InventoryView inventory);

    void closeInventory();

    ItemStack getItemInHand();

    void setItemInHand(ItemStack item);

    ItemStack getItemOnCursor();

    void setItemOnCursor(ItemStack item);

    boolean isSleeping();

    int getSleepTicks();

    GameMode getGameMode();

    void setGameMode(GameMode mode);

    boolean isBlocking();

    int getExpToLevel();
}

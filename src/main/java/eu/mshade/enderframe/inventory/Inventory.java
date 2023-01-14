package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.Agent;
import eu.mshade.enderframe.Watchable;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.mojang.chat.TextComponent;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class Inventory implements Watchable {

    protected InventoryKey inventoryKey;
    protected ItemStack[] itemStacks;
    protected UUID uniqueId;
    protected List<Integer> updateSlots = new ArrayList<>();
    protected Queue<Agent> agents = new ConcurrentLinkedQueue<>();

    public Inventory(InventoryKey inventoryKey, ItemStack[] itemStacks, UUID uniqueId) {
        this.inventoryKey = inventoryKey;
        this.uniqueId = uniqueId;
        this.itemStacks = itemStacks;
        InventoryRepository.INSTANCE.add(this);
    }

    public Inventory(InventoryKey inventoryKey, UUID uniqueId) {
        this(inventoryKey, new ItemStack[inventoryKey.getDefaultSlot()], uniqueId);
    }

    public InventoryKey getInventoryKey() {
        return inventoryKey;
    }

    public void setItemStack(int slot, ItemStack itemStack) {
        if (itemStack != null && itemStack.getMaterial() != null && !itemStack.getMaterial().equals(Material.AIR)) this.itemStacks[slot] = itemStack;
        else this.itemStacks[slot] = null;
        updateSlots.add(slot);
    }


    public void deleteItemStack(int slot){
        this.itemStacks[slot] = null;
        updateSlots.add(slot);
    }

    public ItemStack getItemStack(int slot){
        return this.itemStacks[slot];
    }

    public ItemStack[] getItemStacks() {
        return itemStacks;
    }

    public int findFirstEmptySlot(){
        return findFirstEmptySlot(0);
    }

    public int findFirstEmptySlot(int offset){
        for (int i = offset; i < itemStacks.length; i++) {
            ItemStack itemStack = getItemStack(i);
            if (itemStack == null) return i;
        }
        return -1;
    }

    public ItemStack findItemStack(MaterialKey materialKey, Function<ItemStack, Boolean> filter){
        return findItemStack(0, materialKey, filter);
    }

    public ItemStack findItemStack(int offset, MaterialKey materialKey, Function<ItemStack, Boolean> filter){
        for (int i = offset; i < itemStacks.length; i++) {
            ItemStack itemStack = getItemStack(i);
            if (itemStack == null || !itemStack.getMaterial().equals(materialKey)) continue;
            if (filter.apply(itemStack)) {
                return itemStack;
            }
        }
        return null;
    }


    public int getSize() {
        return itemStacks.length;
    }

    public void fill(ItemStack[] itemStacks) {
        for (int i = 0; i < itemStacks.length; i++) {
            setItemStack(i, itemStacks[i]);
        }
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public Collection<Integer> visitUpdateSlots() {
        Collection<Integer> updateSlots = new ArrayList<>(this.updateSlots);
        this.updateSlots.clear();
        return updateSlots;
    }

    @Override
    public void addWatcher(Agent agent) {
        agents.add(agent);
    }

    @Override
    public void removeWatcher(Agent agent) {
        agents.remove(agent);
    }

    @Override
    public Collection<Agent> getWatchers() {
        return agents;
    }

    @Override
    public boolean isWatching(Agent agent) {
        return agents.contains(agent);
    }

    @Override
    public void notify(Consumer<Agent> agent) {
        agents.forEach(agent);
    }
}

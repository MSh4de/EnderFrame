package eu.mshade.enderframe.item;

import eu.mshade.enderframe.item.meta.PropertyItemMeta;

import java.util.*;

public class ItemStack implements PropertyItemMeta, Cloneable {

    private Material material;
    private int count;
    private int durability;
    private boolean unbreakable;
    private String displayName;
    private List<String> lore = new ArrayList<>();
    private final Map<Enchantment, Integer> enchantments = new HashMap<>();
    private final Set<ItemFlag> itemFlags = new HashSet<>();

    public ItemStack(Material material, int count, int durability) {
        this.material = material;
        this.count = count;
        this.durability = durability;
    }

    @Override
    public boolean hasDisplayName() {
        return displayName != null && displayName.isEmpty();
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public boolean hasLore() {
        return lore.isEmpty();
    }

    @Override
    public List<String> getLore() {
        return lore;
    }

    @Override
    public void setLore(String... lore) {
        this.lore = List.of(lore);
    }

    @Override
    public boolean hasEnchants() {
        return enchantments.isEmpty();
    }

    @Override
    public boolean hasEnchantment(Enchantment enchantment) {
        return enchantments.containsKey(enchantment);
    }

    @Override
    public int getEnchantmentLevel(Enchantment enchantment) {
        return enchantments.getOrDefault(enchantment, 0);
    }

    @Override
    public Map<Enchantment, Integer> getEnchantments() {
        return enchantments;
    }

    @Override
    public void addEnchantment(Enchantment enchantment, int level) {
        enchantments.put(enchantment, level);
    }

    @Override
    public void removeEnchant(Enchantment enchantment) {
        enchantments.remove(enchantment);
    }

    @Override
    public void addItemFlags(ItemFlag... itemFlags) {
        for (ItemFlag itemFlag : itemFlags) this.itemFlags.add(itemFlag);

    }

    @Override
    public void removeItemFlags(ItemFlag... itemFlags) {
        for (ItemFlag itemFlag : itemFlags) this.itemFlags.remove(itemFlag);
    }

    @Override
    public Collection<ItemFlag> getItemFlags() {
        return itemFlags;
    }

    @Override
    public boolean hasItemFlag(ItemFlag itemFlag) {
        return itemFlags.contains(itemFlag);
    }

    public int getCount() {
        return count;
    }

    public ItemStack setCount(int count) {
        this.count = count;
        return this;
    }

    public int getDurability() {
        return durability;
    }

    public ItemStack setDurability(int durability) {
        this.durability = durability;
        return this;
    }

    public boolean isUnbreakable() {
        return unbreakable;
    }

    public ItemStack setUnbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
        return this;
    }

    @Override
    protected ItemStack clone() {
        try {
            return (ItemStack) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

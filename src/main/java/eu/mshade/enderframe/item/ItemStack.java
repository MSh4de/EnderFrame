package eu.mshade.enderframe.item;

import eu.mshade.enderframe.mojang.chat.TextComponent;

import java.util.*;

public class ItemStack implements Cloneable {

    private MaterialKey material;
    private int count;
    private int durability;
    private boolean unbreakable;
    private TextComponent displayName;
    private List<String> lore = new ArrayList<>();
    private final Map<EnchantmentType, Integer> enchantments = new HashMap<>();
    private final Set<ItemFlag> itemFlags = new HashSet<>();
    private final Set<Material> adventureBlocks = new LinkedHashSet<>();

    public ItemStack(MaterialKey material, int count, int durability) {
        this.material = material;
        this.count = count;
        this.durability = durability;
    }

    public MaterialKey getMaterial() {
        return material;
    }

    public boolean hasDisplayName() {
        return displayName != null;
    }

    public TextComponent getDisplayName() {
        return displayName;
    }

    public void setDisplayName(TextComponent displayName) {
        this.displayName = displayName;
    }

    public boolean hasLore() {
        return lore.isEmpty();
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(String... lore) {
        this.lore = List.of(lore);
    }

    public boolean hasEnchants() {
        return !enchantments.isEmpty();
    }

    public boolean hasEnchantment(EnchantmentType enchantmentType) {
        return enchantments.containsKey(enchantmentType);
    }

    public int getEnchantmentLevel(EnchantmentType enchantmentType) {
        return enchantments.getOrDefault(enchantmentType, 0);
    }

    public Map<EnchantmentType, Integer> getEnchantments() {
        return enchantments;
    }

    public void addEnchantment(EnchantmentType enchantmentType, int level) {
        enchantments.put(enchantmentType, level);
    }

    public void removeEnchant(EnchantmentType enchantmentType) {
        enchantments.remove(enchantmentType);
    }

    public void addItemFlags(ItemFlag... itemFlags) {
        for (ItemFlag itemFlag : itemFlags) this.itemFlags.add(itemFlag);

    }

    public void removeItemFlags(ItemFlag... itemFlags) {
        for (ItemFlag itemFlag : itemFlags) this.itemFlags.remove(itemFlag);
    }

    public Collection<ItemFlag> getItemFlags() {
        return itemFlags;
    }

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

    public void addAdventureBlocks(Material material){
        adventureBlocks.add(material);
    }

    public Set<Material> getAdventureBlocks() {
        return adventureBlocks;
    }


    @Override
    protected ItemStack clone() {
        try {
            return (ItemStack) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "ItemStack{" +
                "material=" + material +
                ", count=" + count +
                ", durability=" + durability +
                ", unbreakable=" + unbreakable +
                ", displayName=" + displayName +
                ", lore=" + lore +
                ", enchantments=" + enchantments +
                ", itemFlags=" + itemFlags +
                ", adventureBlocks=" + adventureBlocks +
                '}';
    }
}

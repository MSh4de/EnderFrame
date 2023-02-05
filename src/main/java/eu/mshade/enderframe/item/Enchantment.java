package eu.mshade.enderframe.item;

public class Enchantment {

    private EnchantmentType enchantmentType;
    private int level;

    public Enchantment(EnchantmentType enchantmentType, int level) {
        this.enchantmentType = enchantmentType;
        this.level = level;
    }

    public EnchantmentType getEnchantmentType() {
        return enchantmentType;
    }

    public int getLevel() {
        return level;
    }
}

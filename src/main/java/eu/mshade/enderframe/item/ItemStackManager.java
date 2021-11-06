package eu.mshade.enderframe.item;

import eu.mshade.enderframe.mojang.NamespacedKey;

import java.util.HashMap;
import java.util.Map;

public abstract class ItemStackManager<T, U> {

    private Map<Material, T> materialToWrap = new HashMap<>();
    private Map<T, Material> wrapToMaterial = new HashMap<>();
    private Map<Material, ItemStackRewriter> itemStackRewriter= new HashMap<>();
    private Map<Material, NamespacedKey> materialNamespacedMap = new HashMap<>();
    private Map<Enchantment, U> enchantmentToWrap = new HashMap<>();

    private ItemStackRewriter defaultItemStackRewriter;

    public ItemStackManager(ItemStackRewriter defaultItemStackRewriter) {
        this.defaultItemStackRewriter = defaultItemStackRewriter;
    }

    public void registerMaterialWithWrap(Material material, T wrap){
        materialToWrap.put(material, wrap);
        wrapToMaterial.put(wrap, material);
    }

    public void registerItemStackRewriter(ItemStackRewriter itemStackRewriter, Material... materials){
        for (Material material : materials) {
            this.itemStackRewriter.put(material, itemStackRewriter);
        }
    }

    public void registerNamespacedKey(NamespacedKey namespacedKey, Material... materials) {
        for (Material material : materials) {
            this.materialNamespacedMap.put(material, namespacedKey);
        }
    }

    public void registerEnchantmentWithWrap(Enchantment enchantment, U wrap) {
        this.enchantmentToWrap.put(enchantment, wrap);
    }

    public ItemStackRewriter getItemStackRewriterByMaterial(Material material){
        return this.itemStackRewriter.getOrDefault(material, defaultItemStackRewriter);
    }

    public Material getMaterialByWrap(T wrap){
        return this.wrapToMaterial.get(wrap);
    }

    public T getWrapByMaterial(Material material){
        return this.materialToWrap.get(material);
    }

    public NamespacedKey getNamespacedKeyFromMaterial(Material material) {
        return this.materialNamespacedMap.get(material);
    }

    public U getWrapFromEnchantment(Enchantment enchantment) {
        return this.enchantmentToWrap.get(enchantment);
    }
}

package eu.mshade.enderframe.item;

import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;

import java.util.function.Function;

public class ItemStack implements Cloneable {

    protected MaterialKey material;
    protected int amount;
    protected int durability;
    protected MetadataKeyValueBucket metadataKeyValueBucket;
    protected boolean modified;

    public ItemStack(MaterialKey material, int amount, int durability, MetadataKeyValueBucket metadataKeyValueBucket) {
        this.material = material;
        this.amount = amount;
        this.durability = durability;
        this.metadataKeyValueBucket = metadataKeyValueBucket;
    }

    public ItemStack(MaterialKey material, int amount, int durability) {
        this(material, amount, durability, new MetadataKeyValueBucket(true));
    }

    public ItemStack(MaterialKey material, int amount) {
        this(material, amount, 0, new MetadataKeyValueBucket(true));
    }

    public ItemStack(MaterialKey materialKey) {
        this(materialKey, 1, 0, new MetadataKeyValueBucket(true));
    }

    public MaterialKey getMaterial() {
        return material;
    }

    public ItemStack setMaterial(MaterialKey material) {
        this.material = material;
        modified = true;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public ItemStack modifyAmount(Function<Integer, Integer> function) {
        Integer apply = function.apply(getAmount());
        setAmount(apply);
        return this;
    }

    public ItemStack setAmount(int amount) {
        this.amount = amount;
        modified = true;
        return this;
    }

    public int getDurability() {
        return durability;
    }

    public ItemStack setDurability(int durability) {
        this.durability = durability;
        modified = true;
        return this;
    }


    public MetadataKeyValueBucket getMetadataKeyValueBucket() {
        return metadataKeyValueBucket;
    }

    public boolean matchMetadata(ItemStack itemStack) {
        return itemStack.material == material && itemStack.metadataKeyValueBucket.equals(metadataKeyValueBucket);
    }

    public boolean visitModified() {
        boolean modified = this.modified;
        this.modified = false;
        return modified;
    }

    @Override
    public ItemStack clone() {
        try {
            return (ItemStack) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "ItemStack{" + "material=" + material + ", amount=" + amount + ", durability=" + durability + ", metadataKeyValueBucket=" + metadataKeyValueBucket + '}';
    }
}

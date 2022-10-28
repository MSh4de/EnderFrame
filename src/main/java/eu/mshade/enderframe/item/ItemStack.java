package eu.mshade.enderframe.item;

import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;

import java.util.function.Function;

public class ItemStack implements Cloneable {

    protected MaterialKey material;
    protected int amount;
    protected int durability;
    protected MetadataKeyValueBucket metadataKeyValueBucket;

    public ItemStack(MaterialKey material, int amount, int durability, MetadataKeyValueBucket metadataKeyValueBucket) {
        this.material = material;
        this.amount = amount;
        this.durability = durability;
        this.metadataKeyValueBucket = metadataKeyValueBucket;
    }

    public ItemStack(MaterialKey material, int amount, int durability) {
        this(material, amount, durability, new MetadataKeyValueBucket());
    }

    public ItemStack(MaterialKey material, int amount) {
        this(material, amount, 0, new MetadataKeyValueBucket());
    }

    public ItemStack(MaterialKey materialKey) {
        this(materialKey, 1, 0, new MetadataKeyValueBucket());
    }

    public MaterialKey getMaterial() {
        return material;
    }

    public ItemStack setMaterial(MaterialKey material) {
        this.material = material;
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
        return this;
    }

    public int getDurability() {
        return durability;
    }

    public ItemStack setDurability(int durability) {
        this.durability = durability;
        return this;
    }


    public MetadataKeyValueBucket getMetadataKeyValueBucket() {
        return metadataKeyValueBucket;
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

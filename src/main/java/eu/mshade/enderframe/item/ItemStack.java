package eu.mshade.enderframe.item;

import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;
import eu.mshade.enderframe.mojang.chat.TextComponent;

import java.util.*;

public class ItemStack implements Cloneable {

    protected MaterialKey material;
    protected int count;
    protected int durability;
    protected MetadataKeyValueBucket metadataKeyValueBucket;

    public ItemStack(MaterialKey material, int count, int durability, MetadataKeyValueBucket metadataKeyValueBucket) {
        this.material = material;
        this.count = count;
        this.durability = durability;
        this.metadataKeyValueBucket = metadataKeyValueBucket;
    }

    public ItemStack(MaterialKey material, int count, int durability) {
        this(material, count, durability, new MetadataKeyValueBucket());
    }

    public ItemStack(MaterialKey material, int count) {
        this(material, count, 0, new MetadataKeyValueBucket());
    }

    public ItemStack(MaterialKey materialKey){
        this(materialKey, 1, 0, new MetadataKeyValueBucket());
    }



    public MaterialKey getMaterial() {
        return material;
    }

    public ItemStack setMaterial(MaterialKey material) {
        this.material = material;
        return this;
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

    public MetadataKeyValueBucket getMetadataKeyValueBucket() {
        return metadataKeyValueBucket;
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
                ", metadataKeyValueBucket=" + metadataKeyValueBucket +
                '}';
    }
}

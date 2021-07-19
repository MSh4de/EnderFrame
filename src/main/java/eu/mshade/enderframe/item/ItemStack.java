package eu.mshade.enderframe.item;

public class ItemStack {

    private Material material;
    private int count;
    private int durability;

    public ItemStack(Material material, int count, int durability) {
        this.material = material;
        this.count = count;
        this.durability = durability;
    }


}

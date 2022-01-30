import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.ItemStackManager;
import eu.mshade.enderframe.item.ItemStackRewriter;
import eu.mshade.enderframe.item.Material;
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag;

public class CommonItemStackRewriter implements ItemStackRewriter {

    @Override
    public CompoundBinaryTag write(ItemStackManager itemStackManager, ItemStack itemStack) {



        return null;
    }

    @Override
    public ItemStack read(ItemStackManager itemStackManager, Material material, int count, int durability, CompoundBinaryTag compoundBinaryTag) {
        return null;
    }

}

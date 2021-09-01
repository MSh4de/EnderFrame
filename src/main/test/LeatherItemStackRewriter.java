import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.ItemStackManager;
import eu.mshade.enderframe.item.LeatherCloth;
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag;

public class LeatherItemStackRewriter extends CommonItemStackRewriter{

    @Override
    public CompoundBinaryTag write(ItemStackManager itemStackManager, ItemStack itemStack) {
        LeatherCloth leatherCloth = (LeatherCloth) itemStack;
        CompoundBinaryTag compoundBinaryTag = super.write(itemStackManager, itemStack);

        CompoundBinaryTag property = new CompoundBinaryTag();
        property.putInt("color", leatherCloth.getColor().getRGB());


        return compoundBinaryTag;
    }

    @Override
    public ItemStack read(ItemStackManager itemStackManager, CompoundBinaryTag compoundBinaryTag) {
        return super.read(itemStackManager, compoundBinaryTag);
    }
}

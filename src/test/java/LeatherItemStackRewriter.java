import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.ItemStackManager;
import eu.mshade.enderframe.item.entities.LeatherArmorItemStack;
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag;

public class LeatherItemStackRewriter extends CommonItemStackRewriter{

    @Override
    public CompoundBinaryTag write(ItemStackManager itemStackManager, ItemStack itemStack) {
        LeatherArmorItemStack leatherCloth = (LeatherArmorItemStack) itemStack;
        CompoundBinaryTag compoundBinaryTag = super.write(itemStackManager, itemStack);

        CompoundBinaryTag property = new CompoundBinaryTag();
        property.putInt("color", leatherCloth.getColor().asRGB());


        return compoundBinaryTag;
    }
}

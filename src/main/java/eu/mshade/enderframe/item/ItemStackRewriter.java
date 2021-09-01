package eu.mshade.enderframe.item;

import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag;

public interface ItemStackRewriter {

    CompoundBinaryTag write(ItemStackManager itemStackManager, ItemStack itemStack);

    ItemStack read(ItemStackManager itemStackManager, CompoundBinaryTag compoundBinaryTag);

}

package eu.mshade.enderframe.item;

import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag;

public interface ItemStackRewiter {

    CompoundBinaryTag write(ItemStack itemStack);

    ItemStack read(CompoundBinaryTag compoundBinaryTag);

}

package eu.mshade.enderframe.item;

import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag;

public interface ItemStackMetadataBuffer {

    void write(CompoundBinaryTag compoundBinaryTag, ItemStack itemStack);

    void read(CompoundBinaryTag compoundBinaryTag, ItemStack itemStack);

}

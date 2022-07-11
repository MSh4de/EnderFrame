package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.item.Enchantment;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKeyValue;

import java.util.List;

public class EnchantmentsItemStackMetadata extends ItemStackMetadataKeyValue<List<Enchantment>> {

    public EnchantmentsItemStackMetadata(List<Enchantment> metadataValue) {
        super(ItemStackMetadataKey.ENCHANTMENTS, metadataValue);
    }
}

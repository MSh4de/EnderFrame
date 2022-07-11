package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.item.Enchantment;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKeyValue;

import java.util.List;

public class StoredEnchantmentsItemStackMetadata extends ItemStackMetadataKeyValue<List<Enchantment>> {

    public StoredEnchantmentsItemStackMetadata(List<Enchantment> metadataValue) {
        super(ItemStackMetadataKey.STORED_ENCHANTMENTS, metadataValue);
    }
}

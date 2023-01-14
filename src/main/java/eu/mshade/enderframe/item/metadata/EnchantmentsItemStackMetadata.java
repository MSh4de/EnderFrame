package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.item.Enchantment;
import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.item.ItemStackMetadataKey;

import java.util.List;

public class EnchantmentsItemStackMetadata extends MetadataKeyValue<List<Enchantment>> {

    public EnchantmentsItemStackMetadata(List<Enchantment> metadataValue) {
        super(ItemStackMetadataKey.ENCHANTMENTS, metadataValue);
    }

}

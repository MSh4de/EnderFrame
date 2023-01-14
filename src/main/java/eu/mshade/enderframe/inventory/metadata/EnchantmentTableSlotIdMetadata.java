package eu.mshade.enderframe.inventory.metadata;

import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.metadata.MetadataKeyValue;

public class EnchantmentTableSlotIdMetadata extends MetadataKeyValue<Integer> {

    private EnchantmentTableSlotIdMetadata(MetadataKey metadataKey, Integer metadataValue) {
        super(metadataKey, metadataValue);
    }

    public static EnchantmentTableSlotIdMetadata of(int slot, Integer value) {
        final InventoryMetadataType type = InventoryMetadataType.INSTANCE;

        return switch (slot) {
            case 0 -> new EnchantmentTableSlotIdMetadata(type.getENCHANTMENT_TABLE_TOP_SLOT_ID(), value);
            case 1 -> new EnchantmentTableSlotIdMetadata(type.getENCHANTMENT_TABLE_MIDDLE_SLOT_ID(), value);
            case 2 -> new EnchantmentTableSlotIdMetadata(type.getENCHANTMENT_TABLE_BOTTOM_SLOT_ID(), value);
            default -> throw new IllegalArgumentException("Slot must be between 0 and 2");
        };
    }
}

package eu.mshade.enderframe.inventory.metadata;

import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.metadata.MetadataKeyValue;

public class EnchantmentTableSlotLevelMetadata extends MetadataKeyValue<Integer> {

    private EnchantmentTableSlotLevelMetadata(MetadataKey metadataKey, Integer metadataValue) {
        super(metadataKey, metadataValue);
    }

    public static EnchantmentTableSlotLevelMetadata of(int slot, Integer value) {
        final InventoryMetadataType type = InventoryMetadataType.INSTANCE;

        return switch (slot) {
            case 0 -> new EnchantmentTableSlotLevelMetadata(type.getENCHANTMENT_TABLE_TOP_SLOT_LEVEL(), value);
            case 1 -> new EnchantmentTableSlotLevelMetadata(type.getENCHANTMENT_TABLE_MIDDLE_SLOT_LEVEL(), value);
            case 2 -> new EnchantmentTableSlotLevelMetadata(type.getENCHANTMENT_TABLE_BOTTOM_SLOT_LEVEL(), value);
            default -> throw new IllegalArgumentException("Slot must be between 0 and 2");
        };
    }
}

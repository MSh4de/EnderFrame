package eu.mshade.enderframe.inventory.metadata;

import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.metadata.MetadataKeyValue;

public class BeaconPotionEffectMetadata extends MetadataKeyValue<Integer> {

    private BeaconPotionEffectMetadata(MetadataKey metadataKey, Integer metadataValue) {
        super(metadataKey, metadataValue);
    }

    public static BeaconPotionEffectMetadata of(int slot, Integer value) {
        final InventoryMetadataType type = InventoryMetadataType.INSTANCE;

        return switch (slot) {
            case 0 -> new BeaconPotionEffectMetadata(type.getBEACON_FIRST_POTION_EFFECT(), value);
            case 1 -> new BeaconPotionEffectMetadata(type.getBEACON_SECOND_POTION_EFFECT(), value);
            default -> throw new IllegalArgumentException("Slot must be between 0 and 1");
        };
    }
}

package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.mojang.GameProfile;

public class SkullOwnerItemStackMetadata extends MetadataKeyValue<GameProfile> {

    public SkullOwnerItemStackMetadata(GameProfile metadataValue) {
        super(ItemStackMetadataKey.SKULL_OWNER, metadataValue);
    }
}

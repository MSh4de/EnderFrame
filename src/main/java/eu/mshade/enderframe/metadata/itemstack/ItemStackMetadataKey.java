package eu.mshade.enderframe.metadata.itemstack;

import eu.mshade.enderframe.metadata.MetadataKey;

public enum ItemStackMetadataKey implements MetadataKey {

    UNBREAKABLE,
    CAN_DESTROY,

    CAN_PLACE_ON,
    BLOCK_ENTITY_TAG,

    ENCHANTMENTS,
    STORED_ENCHANTMENTS,
    REPAIR_COST,

    ATTRIBUTE_MODIFIERS,

    CUSTOM_POTION_EFFECTS,
    POTION,

    COLOR,
    NAME,
    LORE,
    HIDE_FLAGS,

    RESOLVED,
    GENERATION,
    AUTHOR,
    TITLE,
    PAGES,

    SKULL_OWNER,


    /**
     * FIREWORK SECTION
     */

    ;

    private String name;

    @Override
    public String getName() {
        return this.name;
    }

}

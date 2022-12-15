package eu.mshade.enderframe.world.block.window;

import java.util.HashMap;
import java.util.Map;

public enum EnchantmentTableWindowProperty implements IWindowProperty {

    TOP_SLOT_LEVEL_REQUIREMENT(0),
    MIDDLE_SLOT_LEVEL_REQUIREMENT(1),
    BOTTOM_SLOT_LEVEL_REQUIREMENT(2),

    ENCHANTMENT_VIEW_SEED(3),

    TOP_SLOT_ENCHANTMENT_ID(4),
    MIDDLE_SLOT_ENCHANTMENT_ID(5),
    BOTTOM_SLOT_ENCHANTMENT_ID(6);

    private static final Map<Integer, EnchantmentTableWindowProperty> ENCHANTMENT_TABLE_PROPERTY_BY_ID = new HashMap<>();

    static {
        for (EnchantmentTableWindowProperty enchantmentTableProperty : values()) {
            ENCHANTMENT_TABLE_PROPERTY_BY_ID.put(enchantmentTableProperty.getId(), enchantmentTableProperty);
        }
    }

    private final int id;

    EnchantmentTableWindowProperty(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public static EnchantmentTableWindowProperty byId(int id) {
        return ENCHANTMENT_TABLE_PROPERTY_BY_ID.get(id);
    }
}

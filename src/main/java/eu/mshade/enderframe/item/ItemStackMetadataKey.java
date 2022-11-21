package eu.mshade.enderframe.item;

import eu.mshade.enderframe.metadata.MetadataKey;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ItemStackMetadataKey  {

    private static final Map<String, MetadataKey> metadataKeyByName = new HashMap<>();

    public static MetadataKey UNBREAKABLE = MetadataKey.from("ITEM_STACK_UNBREAKABLE");
    public static MetadataKey CAN_DESTROY = MetadataKey.from("ITEM_STACK_CAN_DESTROY");
    public static MetadataKey CAN_PLACE_ON = MetadataKey.from("ITEM_STACK_CAN_PLACE_ON");
    public static MetadataKey BLOCK_ENTITY_TAG = MetadataKey.from("ITEM_STACK_BLOCK_ENTITY_TAG");
    public static MetadataKey ENCHANTMENTS = MetadataKey.from("ITEM_STACK_ENCHANTMENTS");
    public static MetadataKey STORED_ENCHANTMENTS = MetadataKey.from("ITEM_STACK_STORED_ENCHANTMENTS");
    public static MetadataKey REPAIR_COST = MetadataKey.from("ITEM_STACK_REPAIR_COST");
    public static MetadataKey ATTRIBUTE_MODIFIERS = MetadataKey.from("ITEM_STACK_ATTRIBUTE_MODIFIERS");
    public static MetadataKey CUSTOM_POTION_EFFECTS = MetadataKey.from("ITEM_STACK_CUSTOM_POTION_EFFECTS");
    public static MetadataKey POTION = MetadataKey.from("ITEM_STACK_POTION");

    /**
     * Display Properties
     */
    public static MetadataKey COLOR = MetadataKey.from("ITEM_STACK_COLOR");
    public static MetadataKey NAME = MetadataKey.from("ITEM_STACK_NAME");
    public static MetadataKey LORE = MetadataKey.from("ITEM_STACK_LORE");
    public static MetadataKey HIDE_FLAGS = MetadataKey.from("ITEM_STACK_HIDE_FLAGS");

    /**
     *
     * Written Books
     */
    public static MetadataKey RESOLVED = MetadataKey.from("ITEM_STACK_RESOLVED");
    public static MetadataKey GENERATION = MetadataKey.from("ITEM_STACK_GENERATION");
    public static MetadataKey AUTHOR = MetadataKey.from("ITEM_STACK_AUTHOR");
    public static MetadataKey TITLE = MetadataKey.from("ITEM_STACK_TITLE");
    public static MetadataKey PAGES = MetadataKey.from("ITEM_STACK_PAGES");

    /**
     * Skull Owner
     */
    public static MetadataKey SKULL_OWNER = MetadataKey.from("ITEM_STACK_SKULL_OWNER");


    /**
     * FIREWORK SECTION
     */

    static {
        try {
            for (Field field : ItemStackMetadataKey.class.getDeclaredFields()) {
                Object o = field.get(null);
                if (o instanceof MetadataKey metadataKey) {
                    register(metadataKey);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void register(MetadataKey metadataKey){
        metadataKeyByName.put(metadataKey.getName(), metadataKey);
    }

    public static MetadataKey getByName(String name){
        return metadataKeyByName.get(name);
    }

}

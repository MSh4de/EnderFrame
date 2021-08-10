package eu.mshade.enderframe.entity;

import java.util.HashMap;
import java.util.Map;

public enum EntityType {
    AREA_EFFECT_CLOUD,
    ARMOR_STAND,
    ARROW,
    AXOLOTL,
    BAT,
    BEE,
    BLAZE,
    BOAT,
    CAT,
    CAVE_SPIDER,
    CHICKEN,
    COD,
    COW,
    CREEPER,
    DOLPHIN,
    DONKEY,
    DRAGON_FIREBALL,
    DROWNED,
    ELDER_GUARDIAN,
    END_CRYSTAL,
    ENDER_DRAGON,
    ENDERMAN,
    ENDERMITE,
    EVOKER,
    EVOKER_FANGS,
    EXPERIENCE_ORB,
    EYE_OF_ENDER,
    FALLING_BLOCK,
    FIREWORK_ROCKET,
    FOX,
    GHAST,
    GIANT,
    GLOW_ITEM_FRAME,
    GLOW_SQUID,
    GOAT,
    GUARDIAN,
    HOGLIN,
    HORSE,
    HORSE_COLOR,
    HORSE_TYPE,
    HUSK,
    ILLUSIONER,
    IRON_GOLEM,
    ITEM,
    ITEM_FRAME,
    FIREBALL,
    LEASH_KNOT,
    LIGHTNING_BOLT,
    LLAMA,
    LLAMA_SPIT,
    MAGMA_CUBE,
    MARKER,
    MINECART,
    CHEST_MINECART,
    COMMANDBLOCK_MINECART,
    FURNACE_MINECART,
    HOPPER_MINECART,
    SPAWNER_MINECART,
    TNT_MINECART,
    MULE,
    MOOSHROOM,
    OCELOT,
    PAINTING,
    PANDA,
    PARROT,
    PHANTOM,
    PIG,
    PIGLIN,
    PIGLIN_BRUTE,
    PILLAGER,
    POLAR_BEAR,
    PRIMED_TNT,
    PUFFERFISH,
    RABBIT,
    RAVAGER,
    SALMON,
    SHEEP,
    SHULKER,
    SHULKER_BULLET,
    SILVERFISH,
    SKELETON,
    SKELETON_HORSE,
    SLIME,
    SMALL_FIREBALL,
    SNOW_GOLEM,
    SNOWBALL,
    SPECTRAL_ARROW,
    SPIDER,
    SQUID,
    STRAY,
    STRIDER,
    EGG,
    ENDER_PEARL,
    EXPERIENCE_BOTTLE,
    POTION,
    TRIDENT,
    TRADER_LLAMA,
    TROPICAL_FISH,
    TURTLE,
    VEX,
    VILLAGER,
    VINDICATOR,
    WANDERING_TRADER,
    WITCH,
    WITHER,
    WITHER_SKELETON,
    WOLF,
    ZOGLIN,
    ZOMBIE(Zombie.class),
    ZOMBIE_HORSE,
    ZOMBIE_VILLAGER,
    ZOMBIFIED_PIGLIN,
    PLAYER(Player.class),
    FISHING_BOOBER;

    private Class<? extends Entity> clazz;
    private static Map<String, EntityType> entityTypeMap = new HashMap<>();

    static{
        for (EntityType value : values()) {
            entityTypeMap.put(value.name(), value);
        }
    }

    EntityType() {

    }

    EntityType(Class<? extends Entity> clazz) {
        this.clazz = clazz;
    }



    public Class<? extends Entity> getClazz() {
        return clazz;
    }

    public static EntityType getEntityTypeByName(String name) {
        return entityTypeMap.get(name);
    }
}

package eu.mshade.enderframe.entity;

import java.util.HashMap;
import java.util.Map;

public enum EntityType {
    AREA_EFFECT_CLOUD,
    ARMOR_STAND(ArmorStand.class),
    ARROW(Arrow.class),
    AXOLOTL,
    BAT(Bat.class),
    BEE,
    BLAZE(Blaze.class),
    BOAT(Boat.class),
    CAT,
    CAVE_SPIDER(CaveSpider.class),
    CHICKEN(Chicken.class),
    COD,
    COW(Cow.class),
    CREEPER(Creeper.class),
    DOLPHIN,
    DONKEY,
    DRAGON_FIREBALL,
    DROWNED,
    ELDER_GUARDIAN,
    END_CRYSTAL(EnderCrystal.class),
    ENDER_DRAGON(EnderDragon.class),
    ENDERMAN(Enderman.class),
    ENDERMITE,
    EVOKER,
    EVOKER_FANGS,
    EXPERIENCE_ORB,
    EYE_OF_ENDER,
    FALLING_BLOCK,
    FIREWORK_ROCKET,
    FOX,
    GHAST(Ghast.class),
    GIANT(GiantZombie.class),
    GLOW_ITEM_FRAME,
    GLOW_SQUID,
    GOAT,
    GUARDIAN(Guardian.class),
    HOGLIN,
    HORSE(Horse.class),
    HUSK,
    ILLUSIONER,
    IRON_GOLEM(IronGolem.class),
    ITEM(Item.class),
    ITEM_FRAME(ItemFrame.class),
    FIREBALL,
    LEASH_KNOT,
    LIGHTNING_BOLT,
    LLAMA,
    LLAMA_SPIT,
    MAGMA_CUBE(MagmaCube.class),
    MARKER,
    MINECART(Minecart.class),
    CHEST_MINECART,
    COMMANDBLOCK_MINECART,
    FURNACE_MINECART(FurnaceMinecart.class),
    HOPPER_MINECART,
    SPAWNER_MINECART,
    TNT_MINECART,
    MULE,
    MOOSHROOM(Mooshroom.class),
    OCELOT(Ocelot.class),
    PAINTING,
    PANDA,
    PARROT,
    PHANTOM,
    PIG(Pig.class),
    PIG_ZOMBIE(ZombiePigman.class),
    PIGLIN,
    PIGLIN_BRUTE,
    PILLAGER,
    POLAR_BEAR,
    PRIMED_TNT,
    PUFFERFISH,
    RABBIT(Rabbit.class),
    RAVAGER,
    SALMON,
    SHEEP(Sheep.class),
    SHULKER,
    SHULKER_BULLET,
    SILVERFISH,
    SKELETON(Skeleton.class),
    SKELETON_HORSE,
    SLIME(Slime.class),
    SMALL_FIREBALL,
    SNOW_GOLEM(Snowman.class),
    SNOWBALL,
    SPECTRAL_ARROW,
    SPIDER(Spider.class),
    SQUID(Squid.class),
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
    VILLAGER(Villager.class),
    VINDICATOR,
    WANDERING_TRADER,
    WITCH(Witch.class),
    WITHER(Wither.class),
    WITHER_SKELETON,
    WOLF(Wolf.class),
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

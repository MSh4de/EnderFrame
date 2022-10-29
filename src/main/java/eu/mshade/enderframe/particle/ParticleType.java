package eu.mshade.enderframe.particle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ParticleType {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParticleType.class);
    private static final Map<String, ParticleKey> PARTICLE_BY_ID = new HashMap<>();

    public static final ParticleKey AMBIENT_ENTITY_EFFECT = ParticleKey.fromId("AMBIENT_ENTITY_EFFECT");
    public static final ParticleKey ANGRY_VILLAGER = ParticleKey.fromId("ANGRY_VILLAGER");
    public static final ParticleKey ASH = ParticleKey.fromId("ASH");
    public static final ParticleKey BARRIER = ParticleKey.fromId("BARRIER");
    public static final ParticleKey BLOCK = ParticleKey.fromId("BLOCK");
    public static final ParticleKey BLOCK_MARKER = ParticleKey.fromId("BLOCK_MARKER");
    public static final ParticleKey BUBBLE = ParticleKey.fromId("BUBBLE");
    public static final ParticleKey BUBBLE_COLUMN_UP = ParticleKey.fromId("BUBBLE_COLUMN_UP");
    public static final ParticleKey BUBBLE_POP = ParticleKey.fromId("BUBBLE_POP");
    public static final ParticleKey CAMPFIRE_COSY_SMOKE = ParticleKey.fromId("CAMPFIRE_COSY_SMOKE");
    public static final ParticleKey CAMPFIRE_SIGNAL_SMOKE = ParticleKey.fromId("CAMPFIRE_SIGNAL_SMOKE");
    public static final ParticleKey CLOUD = ParticleKey.fromId("CLOUD");
    public static final ParticleKey COMPOSTER = ParticleKey.fromId("COMPOSTER");
    public static final ParticleKey CRIMSON_SPORE = ParticleKey.fromId("CRIMSON_SPORE");
    public static final ParticleKey CRIT = ParticleKey.fromId("CRIT");
    public static final ParticleKey CURRENT_DOWN = ParticleKey.fromId("CURRENT_DOWN");
    public static final ParticleKey DAMAGE_INDICATOR = ParticleKey.fromId("DAMAGE_INDICATOR");
    public static final ParticleKey DOLPHIN = ParticleKey.fromId("DOLPHIN");
    public static final ParticleKey DRAGON_BREATH = ParticleKey.fromId("DRAGON_BREATH");
    public static final ParticleKey DRIPPING_DRIPSTONE_LAVA = ParticleKey.fromId("DRIPPING_DRIPSTONE_LAVA");
    public static final ParticleKey DRIPPING_DRIPSTONE_WATER = ParticleKey.fromId("DRIPPING_DRIPSTONE_WATER");
    public static final ParticleKey DRIPPING_HONEY = ParticleKey.fromId("DRIPPING_HONEY");
    public static final ParticleKey DRIPPING_LAVA = ParticleKey.fromId("DRIPPING_LAVA");
    public static final ParticleKey DRIPPING_WATER = ParticleKey.fromId("DRIPPING_WATER");
    public static final ParticleKey DRIPPING_OBSIDIAN_TEAR = ParticleKey.fromId("DRIPPING_OBSIDIAN_TEAR");
    public static final ParticleKey DUST = ParticleKey.fromId("DUST");
    public static final ParticleKey DUST_COLOR_TRANSITION = ParticleKey.fromId("DUST_COLOR_TRANSITION");
    public static final ParticleKey EFFECT = ParticleKey.fromId("EFFECT");
    public static final ParticleKey ELDER_GUARDIAN = ParticleKey.fromId("ELDER_GUARDIAN");
    public static final ParticleKey ELECTRIC_SPARK = ParticleKey.fromId("ELDER_GUARDIAN");
    public static final ParticleKey ENCHANT = ParticleKey.fromId("ELDER_GUARDIAN");
    public static final ParticleKey ENCHANTED_HIT = ParticleKey.fromId("ENCHANTED_HIT");
    public static final ParticleKey END_ROD = ParticleKey.fromId("END_ROD");
    public static final ParticleKey ENTITY_EFFECT = ParticleKey.fromId("ENTITY_EFFECT");
    public static final ParticleKey EXPLOSION = ParticleKey.fromId("EXPLOSION");
    public static final ParticleKey EXPLOSION_EMITTER = ParticleKey.fromId("EXPLOSION_EMITTER");
    public static final ParticleKey FALLING_DRIPSTONE_LAVA = ParticleKey.fromId("FALLING_DRIPSTONE_LAVA");
    public static final ParticleKey FALLING_DRIPSTONE_WATER = ParticleKey.fromId("FALLING_DRIPSTONE_WATER");
    public static final ParticleKey FALLING_DUST = ParticleKey.fromId("FALLING_DUST");
    public static final ParticleKey FALLING_HONEY = ParticleKey.fromId("FALLING_HONEY");
    public static final ParticleKey FALLING_NECTAR = ParticleKey.fromId("FALLING_NECTAR");
    public static final ParticleKey FALLING_LAVA = ParticleKey.fromId("FALLING_LAVA");
    public static final ParticleKey FALLING_SPORE_BLOSSOM = ParticleKey.fromId("FALLING_SPORE_BLOSSOM");
    public static final ParticleKey FALLING_WATER = ParticleKey.fromId("FALLING_WATER");
    public static final ParticleKey FALLING_OBSIDIAN_TEAR = ParticleKey.fromId("FALLING_OBSIDIAN_TEAR");
    public static final ParticleKey FIREWORK = ParticleKey.fromId("FIREWORK");
    public static final ParticleKey FISHING = ParticleKey.fromId("FISHING");
    public static final ParticleKey FLAME = ParticleKey.fromId("FLAME");
    public static final ParticleKey FLASH = ParticleKey.fromId("FLASH");
    public static final ParticleKey GLOW = ParticleKey.fromId("GLOW");
    public static final ParticleKey GLOW_SQUID_LINK = ParticleKey.fromId("GLOW_SQUID_LINK");
    public static final ParticleKey HAPPY_VILLAGER = ParticleKey.fromId("HAPPY_VILLAGER");
    public static final ParticleKey HEART = ParticleKey.fromId("HEART");
    public static final ParticleKey INSTANT_EFFECT = ParticleKey.fromId("INSTANT_EFFECT");
    public static final ParticleKey ITEM = ParticleKey.fromId("ITEM");
    public static final ParticleKey ITEM_SLIME = ParticleKey.fromId("ITEM_SLIME");
    public static final ParticleKey ITEM_SNOWBALL = ParticleKey.fromId("ITEM_SNOWBALL");
    public static final ParticleKey LANDING_HONEY = ParticleKey.fromId("LANDING_HONEY");
    public static final ParticleKey LANDING_LAVA = ParticleKey.fromId("LANDING_LAVA");
    public static final ParticleKey LANDING_OBSIDIAN_TEER = ParticleKey.fromId("LANDING_OBSIDIAN_TEER");
    public static final ParticleKey LARGE_SMOKE = ParticleKey.fromId("LARGE_SMOKE");
    public static final ParticleKey LAVA = ParticleKey.fromId("LAVA");
    public static final ParticleKey LIGHT = ParticleKey.fromId("LIGHT");
    public static final ParticleKey MYCELIUM = ParticleKey.fromId("MYCELIUM");
    public static final ParticleKey NAUTILUS = ParticleKey.fromId("NAUTILUS");
    public static final ParticleKey NOTE = ParticleKey.fromId("NOTE");
    public static final ParticleKey POOF = ParticleKey.fromId("POOF");
    public static final ParticleKey PORTAL = ParticleKey.fromId("PORTAL");
    public static final ParticleKey RAIN = ParticleKey.fromId("RAIN");
    public static final ParticleKey SCRAPE = ParticleKey.fromId("SCRAPE");
    public static final ParticleKey SCULK_CHARGE = ParticleKey.fromId("SCULK_CHARGE");
    public static final ParticleKey SCULK_CHARGE_POP = ParticleKey.fromId("SCULK_CHARGE_POP");
    public static final ParticleKey SCULK_SOUL = ParticleKey.fromId("SCULK_SOUL");
    public static final ParticleKey SHRIEK = ParticleKey.fromId("SHRIEK");
    public static final ParticleKey SMOKE = ParticleKey.fromId("SMOKE");
    public static final ParticleKey SNEEZE = ParticleKey.fromId("SNEEZE");
    public static final ParticleKey SNOWFLAKE = ParticleKey.fromId("SNOWFLAKE");
    public static final ParticleKey SONIC_BOOM = ParticleKey.fromId("SONIC_BOOM");
    public static final ParticleKey SOUL = ParticleKey.fromId("SOUL");
    public static final ParticleKey SOUL_FIRE_FLAME = ParticleKey.fromId("SOUL_FIRE_FLAME");
    public static final ParticleKey SPIT = ParticleKey.fromId("SPIT");
    public static final ParticleKey SPORE_BLOSSOM_AIR = ParticleKey.fromId("SPORE_BLOSSOM_AIR");
    public static final ParticleKey SPLASH = ParticleKey.fromId("SPLASH");
    public static final ParticleKey SQUID_INK = ParticleKey.fromId("SQUID_INK");
    public static final ParticleKey SWEEP_ATTACK = ParticleKey.fromId("SWEEP_ATTACK");
    public static final ParticleKey TOTEM_OF_UNDYING = ParticleKey.fromId("TOTEM_OF_UNDYING");
    public static final ParticleKey UNDERWATER = ParticleKey.fromId("UNDERWATER");
    public static final ParticleKey VIBRATION = ParticleKey.fromId("VIBRATION");
    public static final ParticleKey WARPED_SPORE = ParticleKey.fromId("WARPED_SPORE");
    public static final ParticleKey WAX_OFF = ParticleKey.fromId("WAX_OFF");
    public static final ParticleKey WAX_ON = ParticleKey.fromId("WAX_ON");
    public static final ParticleKey WITCH = ParticleKey.fromId("WITCH");

    /**
     * DEPTH_SUSPEND AND FOOTSTEP are removed on 1.13
     */
    public static final ParticleKey DEPTH_SUSPENDED = ParticleKey.fromId("DEPTH_SUSPENDED");
    public static final ParticleKey FOOTSTEP = ParticleKey.fromId("FOOTSTEP");

    static {
        Field[] declaredFields = ParticleType.class.getDeclaredFields();

        try {
            for (Field field : declaredFields) {
                Object object = field.get(null);

                if (object instanceof ParticleKey particleKey) {
                    LOGGER.debug("Register " + particleKey);
                    registerParticleKey(particleKey);
                }
            }
        } catch (IllegalAccessException e){
            LOGGER.error("", e);
        }

        LOGGER.info("Register {} particles", PARTICLE_BY_ID.size());
    }

    private static void registerParticleKey(ParticleKey particleKey) {
        PARTICLE_BY_ID.put(particleKey.id(), particleKey);
    }

    public static Collection<ParticleKey> getParticleById() {
        return PARTICLE_BY_ID.values();
    }
}

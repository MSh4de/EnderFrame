package eu.mshade.enderframe.sound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Sound {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sound.class);
    private static final Map<String, SoundKey> SOUND_BY_NAME = new HashMap<>();

    public static final SoundKey AMBIENT_CAVE = SoundKey.fromName("ambient.cave.cave");
    public static final SoundKey AMBIENT_WEATHER_RAIN = SoundKey.fromName("ambient.weather.rain");
    public static final SoundKey AMBIENT_WEATHER_THUNDER = SoundKey.fromName("ambient.weather.thunder");
    public static final SoundKey DAMAGE_FALLBIG = SoundKey.fromName("damage.fallbig");
    public static final SoundKey DAMAGE_FALLSMAL = SoundKey.fromName("damage.fallsmall");
    public static final SoundKey FIRE_ACTIVE = SoundKey.fromName("fire.fire");
    public static final SoundKey FIRE_IGNITE = SoundKey.fromName("fire.ignite");
    public static final SoundKey LIQUID_LAVA = SoundKey.fromName("liquid.lava");
    public static final SoundKey LIQUID_LAVAPOP = SoundKey.fromName("liquid.lavapop");
    public static final SoundKey LIQUID_SPLASH = SoundKey.fromName("liquid.splash");
    public static final SoundKey LIQUID_WATER = SoundKey.fromName("liquid.water");
    public static final SoundKey MOB_BLAZE_BREATHE = SoundKey.fromName("mob.blaze.breathe");
    public static final SoundKey MOB_BLAZE_DEATH = SoundKey.fromName("mob.blaze.death");
    public static final SoundKey MOB_BLAZE_HIT = SoundKey.fromName("mob.blaze.hit");
    public static final SoundKey MOB_CAT_HISS = SoundKey.fromName("mob.cat.hiss");
    public static final SoundKey MOB_CAT_HIT = SoundKey.fromName("mob.cat.hitt");
    public static final SoundKey MOB_CAT_MEOW = SoundKey.fromName("mob.cat.meow");
    public static final SoundKey MOB_CAT_PURR = SoundKey.fromName("mob.cat.purr");
    public static final SoundKey MOB_CAT_PURREOW = SoundKey.fromName("mob.cat.purreow");
    public static final SoundKey MOB_CHIKEN_HURT = SoundKey.fromName("mob.chicken.hurt");
    public static final SoundKey MOB_CHIKEN_PLOP = SoundKey.fromName("mob.chicken.plop");
    public static final SoundKey MOB_COW_HURT = SoundKey.fromName("mob.cow.hurt");
    public static final SoundKey MOB_CREEPER = SoundKey.fromName("mob.creeper");
    public static final SoundKey MOB_CREEPER_DEATH = SoundKey.fromName("mob.creeperdeath");
    public static final SoundKey MOB_ENDERMEN_DEATH = SoundKey.fromName("mob.endermen.death");
    public static final SoundKey MOB_ENDERMEN_HIT = SoundKey.fromName("mob.endermen.hit");
    public static final SoundKey MOB_ENDERMEN_IDLE = SoundKey.fromName("mob.endermen.idle");
    public static final SoundKey MOB_ENDERMEN_PORTAL = SoundKey.fromName("mob.endermen.portal");
    public static final SoundKey MOB_ENDERMEN_SCREAM = SoundKey.fromName("mob.endermen.scream");
    public static final SoundKey MOB_ENDERMEN_STARE = SoundKey.fromName("mob.endermen.stare");
    public static final SoundKey MOB_GHAST_AFFECTIONATESCREAM = SoundKey.fromName("mob.ghast.affectionate scream");
    public static final SoundKey MOB_GHAST_CHARGE = SoundKey.fromName("mob.ghast.charge");
    public static final SoundKey MOB_GHAST_DEATH = SoundKey.fromName("mob.ghast.death");
    public static final SoundKey MOB_GHAST_FIREBALL = SoundKey.fromName("mob.ghast.fireball");
    public static final SoundKey MOB_GHAST_MOAN = SoundKey.fromName("mob.ghast.moan");
    public static final SoundKey MOB_GHAST_SCREAM = SoundKey.fromName("mob.ghast.scream");
    public static final SoundKey MOB_IRONGOLEM_DEATH = SoundKey.fromName("mob.irongolem.death");
    public static final SoundKey MOB_IRONGOLEM_HIT = SoundKey.fromName("mob.irongolem.hit");
    public static final SoundKey MOB_IRONGOLEM_THROW = SoundKey.fromName("mob.irongolem.throw");
    public static final SoundKey MOB_IRONGOLEM_WALK = SoundKey.fromName("mob.irongolem.walk");
    public static final SoundKey MOB_MAGMACUBE_BIG = SoundKey.fromName("mob.magmacube.big");
    public static final SoundKey MOB_MAGMACUBE_JUMP = SoundKey.fromName("mob.magmacube.jump");
    public static final SoundKey MOB_MAGMACUBE_SMALL = SoundKey.fromName("mob.magmacube.small");
    public static final SoundKey MOB_SILVERFISH_HIT = SoundKey.fromName("mob.silverfish.hit");
    public static final SoundKey MOB_SILVERFISH_KILL = SoundKey.fromName("mob.silverfish.kill");
    public static final SoundKey MOB_SILVERFISH_SAY = SoundKey.fromName("mob.silverfish.say");
    public static final SoundKey MOB_SILVERFISH_STEP = SoundKey.fromName("mob.silverfish.step");
    public static final SoundKey MOB_SKELETON_DEATH = SoundKey.fromName("mob.skeleton.death");
    public static final SoundKey MOB_SKELETON_HURT = SoundKey.fromName("mob.skeleton.hurt");
    public static final SoundKey MOB_SPIDER_DEATH = SoundKey.fromName("mob.spider.death");
    public static final SoundKey MOB_WOLF_BARK = SoundKey.fromName("mob.wolf.bark");
    public static final SoundKey MOB_WOLF_DEATH = SoundKey.fromName("mob.wolf.death");
    public static final SoundKey MOB_WOLF_GROWL = SoundKey.fromName("mob.wolf.growl");
    public static final SoundKey MOB_WOLF_HOWL = SoundKey.fromName("mob.wolf.howl");
    public static final SoundKey MOB_WOLF_HURT = SoundKey.fromName("mob.wolf.hurt");
    public static final SoundKey MOB_WOLF_PANTING = SoundKey.fromName("mob.wolf.panting");
    public static final SoundKey MOB_WOLF_SHAKE = SoundKey.fromName("mob.wolf.shake");
    public static final SoundKey MOB_WOLF_WHINE = SoundKey.fromName("mob.wolf.whine");
    public static final SoundKey MOB_ZOMBIE_METAL = SoundKey.fromName("mob.zombie.metal");
    public static final SoundKey MOB_ZOMBIE_WOOD = SoundKey.fromName("mob.zombie.wood");
    public static final SoundKey MOB_ZOMBIE_WOODBREAK = SoundKey.fromName("mob.zombie.woodbreak");
    public static final SoundKey MOB_ZOMBIE = SoundKey.fromName("mob.zombie");
    public static final SoundKey MOB_ZOMBIE_HURT = SoundKey.fromName("mob.zombie.hurt");
    public static final SoundKey MOB_ZOMBIEPIG_ZPIG = SoundKey.fromName("mob.zombiepig.zpig");
    public static final SoundKey MOB_ZOMBIEPIG_ZPIGANGRY = SoundKey.fromName("mob.zombiepig.zpigangry");
    public static final SoundKey MOB_ZOMBIEPIG_ZPIGDEATH = SoundKey.fromName("mob.zombiepig.zpigdeath");
    public static final SoundKey MOB_ZOMBIEPIG_ZPIGHURT = SoundKey.fromName("mob.zombiepig.zpighurt");
    public static final SoundKey NOTE_BASS = SoundKey.fromName("note.bass");
    public static final SoundKey NOTE_BASSATTACK = SoundKey.fromName("note.bassattack");
    public static final SoundKey NOTE_BD = SoundKey.fromName("note.bd");
    public static final SoundKey NOTE_HARP = SoundKey.fromName("note.harp");
    public static final SoundKey NOTE_HAT = SoundKey.fromName("note.hat");
    public static final SoundKey NOTE_PLING = SoundKey.fromName("note.pling");
    public static final SoundKey NOTE_SNARE = SoundKey.fromName("note.snare");
    public static final SoundKey PORTAL_NEAR = SoundKey.fromName("portal.portal");
    public static final SoundKey PORTAL_TRAVEL = SoundKey.fromName("portal.travel");
    public static final SoundKey PORTAL_TRIGGER = SoundKey.fromName("portal.trigger");
    public static final SoundKey RANDOM_BOW = SoundKey.fromName("random.bow");
    public static final SoundKey RANDOM_BOWHIT = SoundKey.fromName("random.bowhit");
    public static final SoundKey RANDOM_BREAK = SoundKey.fromName("random.break");
    public static final SoundKey RANDOM_BREATH = SoundKey.fromName("random.breath");
    public static final SoundKey RANDOM_BURP = SoundKey.fromName("random.burp");
    public static final SoundKey RANDOM_CHESTCLOSED = SoundKey.fromName("random.chestclosed");
    public static final SoundKey RANDOM_CHESTOPEN = SoundKey.fromName("random.chestopen");
    public static final SoundKey RANDOM_CLICK = SoundKey.fromName("random.click");
    public static final SoundKey RANDOM_DOOR_CLOSE = SoundKey.fromName("random.door_close");
    public static final SoundKey RANDOM_DOOR_OPEN = SoundKey.fromName("random.door_open");
    public static final SoundKey RANDOM_DRINK = SoundKey.fromName("random.drink");
    public static final SoundKey RANDOM_EAT = SoundKey.fromName("random.eat");
    public static final SoundKey RANDOM_EXPLODE = SoundKey.fromName("random.explode");
    public static final SoundKey RANDOM_FIZZ = SoundKey.fromName("random.fizz");
    public static final SoundKey RANDOM_FUSE = SoundKey.fromName("random.fuse");
    public static final SoundKey RANDOM_GLASS = SoundKey.fromName("random.glass");
    public static final SoundKey RANDOM_LEVELUP = SoundKey.fromName("random.levelup");
    public static final SoundKey RANDOM_OLDEXPLODE = SoundKey.fromName("random.old_explode");
    public static final SoundKey RANDOM_ORB = SoundKey.fromName("random.orb");
    public static final SoundKey RANDOM_POP = SoundKey.fromName("random.pop");
    public static final SoundKey RANDOM_SPLASH = SoundKey.fromName("random.splash");
    public static final SoundKey RANDOM_WOODCLICK = SoundKey.fromName("random.wood click");
    public static final SoundKey STEP_CLOTH = SoundKey.fromName("step.cloth");
    public static final SoundKey STEP_GRASS = SoundKey.fromName("step.grass");
    public static final SoundKey STEP_GRAVEL = SoundKey.fromName("step.gravel");
    public static final SoundKey STEP_SAND = SoundKey.fromName("step.sand");
    public static final SoundKey STEP_SNOW = SoundKey.fromName("step.snow");
    public static final SoundKey STEP_STONE = SoundKey.fromName("step.stone");
    public static final SoundKey STEP_WOOD = SoundKey.fromName("step.wood");
    public static final SoundKey TILE_PISTON_IN = SoundKey.fromName("tile.piston.in");
    public static final SoundKey TILE_PISTON_OUT = SoundKey.fromName("tile.piston.out");
    public static final SoundKey DAMAGE_HIT = SoundKey.fromName("damage.hit");
    public static final SoundKey DIG_CLOTH = SoundKey.fromName("dig.cloth");
    public static final SoundKey DIG_GRASS = SoundKey.fromName("dig.grass");
    public static final SoundKey DIG_GRAVEL = SoundKey.fromName("dig.gravel");
    public static final SoundKey DIG_SAND = SoundKey.fromName("dig.sand");
    public static final SoundKey DIG_SNOW = SoundKey.fromName("dig.snow");
    public static final SoundKey DIG_STONE = SoundKey.fromName("dig.stone");
    public static final SoundKey DIG_WOOD = SoundKey.fromName("dig.wood");
    public static final SoundKey LIQUID_SWIM = SoundKey.fromName("liquid.swim");
    public static final SoundKey MINECART_BASE = SoundKey.fromName("minecart.base");
    public static final SoundKey MINECART_INSIDE = SoundKey.fromName("minecart.inside");
    public static final SoundKey MOB_CHIKEN_SAY = SoundKey.fromName("mob.chicken.say");
    public static final SoundKey MOB_CHIKEN_STEP = SoundKey.fromName("mob.chicken.step");
    public static final SoundKey MOB_COW_SAY = SoundKey.fromName("mob.cow.say");
    public static final SoundKey MOB_COW_STEP = SoundKey.fromName("mob.cow.step");
    public static final SoundKey MOB_CREAPER_SAY = SoundKey.fromName("mob.creeper.say");
    public static final SoundKey MOB_PIG_DEATH = SoundKey.fromName("mob.pig.death");
    public static final SoundKey MOB_PIG_SAY = SoundKey.fromName("mob.pig.say");
    public static final SoundKey MOB_PIG_STEP = SoundKey.fromName("mob.pig.step");
    public static final SoundKey MOB_SHEEP_SAY = SoundKey.fromName("mob.sheep.say");
    public static final SoundKey MOB_SHEEP_SHEAR = SoundKey.fromName("mob.sheep.shear");
    public static final SoundKey MOB_SHEEP_STEP = SoundKey.fromName("mob.sheep.step");
    public static final SoundKey MOB_SKELETON_SAY = SoundKey.fromName("mob.skeleton.say");
    public static final SoundKey MOB_SKELETON_STEP = SoundKey.fromName("mob.skeleton.step");
    public static final SoundKey MOB_SLIME_ATTACK = SoundKey.fromName("mob.slime.attack");
    public static final SoundKey MOB_SLIME_BIG = SoundKey.fromName("mob.slime.big");
    public static final SoundKey MOB_SLIME_SMALL = SoundKey.fromName("mob.slime.small");
    public static final SoundKey MOB_SPIDER_SAY = SoundKey.fromName("mob.spider.say");
    public static final SoundKey MOB_SPIDER_STEP = SoundKey.fromName("mob.spider.step");
    public static final SoundKey MOB_WOLF_STEP = SoundKey.fromName("mob.wolf.step");
    public static final SoundKey MOB_ZOMBIE_DEATH = SoundKey.fromName("mob.zombie.death");
    public static final SoundKey MOB_ZOMBIE_SAY = SoundKey.fromName("mob.zombie.say");
    public static final SoundKey MOB_ZOMBIE_STEP = SoundKey.fromName("mob.zombie.step");
    public static final SoundKey RANDOM_CLASSIC_HURT = SoundKey.fromName("random.classic_hurt");
    public static final SoundKey STEP_LADDER = SoundKey.fromName("step.ladder");
    public static final SoundKey MOB_BAT_DEATH = SoundKey.fromName("mob.bat.death");
    public static final SoundKey MOB_BAT_HURT = SoundKey.fromName("mob.bat.hurt");
    public static final SoundKey MOB_BAT_IDLE = SoundKey.fromName("mob.bat.idle");
    public static final SoundKey MOB_BAT_TAKEOFF = SoundKey.fromName("mob.bat.takeoff");
    public static final SoundKey MOB_ENDERDRAGON_END = SoundKey.fromName("mob.enderdragon.end");
    public static final SoundKey MOB_ENDERDRAGON_GROWL = SoundKey.fromName("mob.enderdragon.growl");
    public static final SoundKey MOB_ENDERDRAGON_HIT = SoundKey.fromName("mob.enderdragon.hit");
    public static final SoundKey MOB_ENDERDRAGON_WINGS = SoundKey.fromName("mob.enderdragon.wings");
    public static final SoundKey MOB_WITHER_DEATH = SoundKey.fromName("mob.wither.death");
    public static final SoundKey MOB_WITHER_HURT = SoundKey.fromName("mob.wither.hurt");
    public static final SoundKey MOB_WITHER_IDLE = SoundKey.fromName("mob.wither.idle");
    public static final SoundKey MOB_WITHER_SHOOT = SoundKey.fromName("mob.wither.shoot");
    public static final SoundKey MOB_WITHER_SPAWN = SoundKey.fromName("mob.wither.spawn");
    public static final SoundKey MOB_ZOMBIE_INFECT = SoundKey.fromName("mob.zombie.infect");
    public static final SoundKey MOB_ZOMBIE_REMEDY = SoundKey.fromName("mob.zombie.remedy");
    public static final SoundKey MOB_ZOMBIE_UNFECT = SoundKey.fromName("mob.zombie.unfect");
    public static final SoundKey RANDOM_ANVIL_BREAK = SoundKey.fromName("random.anvil_break");
    public static final SoundKey RANDOM_ANVIL_LAND = SoundKey.fromName("random.anvil_land");
    public static final SoundKey RANDOM_ANVIL_USE = SoundKey.fromName("random.anvil_use");

    static {
        Field[] declaredFields = Sound.class.getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                Object object = field.get(null);

                if (object instanceof SoundKey soundKey) {
                    LOGGER.debug("Register "+ soundKey);
                    registerSoundKey(soundKey);
                }
            }
        } catch (IllegalAccessException e){
            LOGGER.error("", e);
        }

        LOGGER.info("Register {} sounds", SOUND_BY_NAME.size());
    }

    private static void registerSoundKey(SoundKey soundKey) {
        SOUND_BY_NAME.put(soundKey.name(), soundKey);
    }
}

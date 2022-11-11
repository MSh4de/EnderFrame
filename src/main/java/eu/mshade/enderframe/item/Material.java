package eu.mshade.enderframe.item;

import eu.mshade.enderframe.mojang.NamespacedKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;

public class Material {


    private static Logger LOGGER = LoggerFactory.getLogger(Material.class);

    private final static Map<String, NamespacedKey> NAMESPACED_BY_MATERIAL = new HashMap<>();
    private final static Map<Integer, MaterialKey> MATERIAL_BY_ID = new HashMap<>();
    private final static Map<NamespacedKey, MaterialKey> MATERIAL_KEY_BY_NAMESPACED_KEY = new HashMap<>();
    private final static Map<MaterialCategoryKey, Set<MaterialKey>> MATERIAL_KEYS_BY_CATEGORY = new HashMap<>();

    public static MaterialKey AIR = MaterialKey.from(0, NamespacedKey.minecraft("air"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey STONE = MaterialKey.from(1, 64, NamespacedKey.minecraft("stone"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey GRANITE = MaterialKey.from(2, 64, NamespacedKey.minecraft("granite"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey POLISHED_GRANITE = MaterialKey.from(3, 64, NamespacedKey.minecraft("polished_granite"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DIORITE = MaterialKey.from(4, 64, NamespacedKey.minecraft("diorite"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey POLISHED_DIORITE = MaterialKey.from(5, 64, NamespacedKey.minecraft("polished_diorite"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey ANDESITE = MaterialKey.from(6, 64, NamespacedKey.minecraft("andesite"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey POLISHED_ANDESITE = MaterialKey.from(7, 64, NamespacedKey.minecraft("polished_andesite"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey GRASS = MaterialKey.from(8, 64, NamespacedKey.minecraft("grass"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DIRT = MaterialKey.from(9, 64, NamespacedKey.minecraft("dirt"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey COARSE_DIRT = MaterialKey.from(10, 64, NamespacedKey.minecraft("coarse_dirt"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey PODZOL = MaterialKey.from(11, 64, NamespacedKey.minecraft("podzol"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey COBBLESTONE = MaterialKey.from(12, 64, NamespacedKey.minecraft("cobblestone"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));

    public static MaterialKey OAK_WOOD_PLANKS = MaterialKey.from(13, 64, NamespacedKey.minecraft("oak_wood_planks"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey SPRUCE_WOOD_PLANKS = MaterialKey.from(14, 64, NamespacedKey.minecraft("spruce_wood_planks"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey BIRCH_WOOD_PLANKS = MaterialKey.from(15, 64, NamespacedKey.minecraft("birch_wood_planks"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey JUNGLE_WOOD_PLANKS = MaterialKey.from(16, 64, NamespacedKey.minecraft("jungle_wood_planks"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey ACACIA_WOOD_PLANKS = MaterialKey.from(17, 64, NamespacedKey.minecraft("acacia_wood_planks"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey DARK_OAK_WOOD_PLANKS = MaterialKey.from(18, 64, NamespacedKey.minecraft("dark_oak_wood_planks"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));


    public static MaterialKey OAK_SAPLING = MaterialKey.from(19, 64, NamespacedKey.minecraft("oak_sapling"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.PLANT));
    public static MaterialKey SPRUCE_SAPLING = MaterialKey.from(20, 64, NamespacedKey.minecraft("spruce_sapling"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.PLANT));
    public static MaterialKey BIRCH_SAPLING = MaterialKey.from(21, 64, NamespacedKey.minecraft("birch_sapling"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.PLANT));
    public static MaterialKey JUNGLE_SAPLING = MaterialKey.from(22, 64, NamespacedKey.minecraft("jungle_sapling"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.PLANT));
    public static MaterialKey ACACIA_SAPLING = MaterialKey.from(23, 64, NamespacedKey.minecraft("acacia_sapling"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.PLANT));
    public static MaterialKey DARK_OAK_SAPLING = MaterialKey.from(24, 64, NamespacedKey.minecraft("dark_oak_sapling"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.PLANT));


    public static MaterialKey BEDROCK = MaterialKey.from(25, 64, NamespacedKey.minecraft("bedrock"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey WATER = MaterialKey.from(26, 64, NamespacedKey.minecraft("water"), MaterialCategory.FLUID, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey FLOWING_WATER = MaterialKey.from(27, 64, NamespacedKey.minecraft("flowing_water"), MaterialCategory.FLUID, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey LAVA = MaterialKey.from(28, 64, NamespacedKey.minecraft("lava"), MaterialCategory.FLUID, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey FLOWING_LAVA = MaterialKey.from(29, 64, NamespacedKey.minecraft("flowing_lava"), MaterialCategory.FLUID, Set.of(MaterialCategory.BLOCK));

    public static MaterialKey GRAVEL = MaterialKey.from(32, 64, NamespacedKey.minecraft("gravel"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));

    //register all ores of minecraft 1.19
    public static MaterialKey GOLD_ORE = MaterialKey.from(33, 64, NamespacedKey.minecraft("gold_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey IRON_ORE = MaterialKey.from(34, 64, NamespacedKey.minecraft("iron_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey COAL_ORE = MaterialKey.from(35, 64, NamespacedKey.minecraft("coal_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey LAPIS_LAZULI_ORE = MaterialKey.from(36, 64, NamespacedKey.minecraft("lapis_lazuli_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey DIAMOND_ORE = MaterialKey.from(37, 64, NamespacedKey.minecraft("diamond_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey REDSTONE_ORE = MaterialKey.from(38, 64, NamespacedKey.minecraft("redstone_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey EMERALD_ORE = MaterialKey.from(39, 64, NamespacedKey.minecraft("emerald_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey NETHER_QUARTZ_ORE = MaterialKey.from(40, 64, NamespacedKey.minecraft("nether_quartz_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey ANCIENT_DEBRIS = MaterialKey.from(41, 64, NamespacedKey.minecraft("ancient_debris"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey COPPER_ORE = MaterialKey.from(42, 64, NamespacedKey.minecraft("copper_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey DEEPSLATE_GOLD_ORE = MaterialKey.from(43, 64, NamespacedKey.minecraft("deepslate_gold_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey DEEPSLATE_IRON_ORE = MaterialKey.from(44, 64, NamespacedKey.minecraft("deepslate_iron_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey DEEPSLATE_COAL_ORE = MaterialKey.from(45, 64, NamespacedKey.minecraft("deepslate_coal_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey DEEPSLATE_LAPIS_LAZULI_ORE = MaterialKey.from(46, 64, NamespacedKey.minecraft("deepslate_lapis_lazuli_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey DEEPSLATE_DIAMOND_ORE = MaterialKey.from(47, 64, NamespacedKey.minecraft("deepslate_diamond_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey DEEPSLATE_REDSTONE_ORE = MaterialKey.from(48, 64, NamespacedKey.minecraft("deepslate_redstone_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey DEEPSLATE_EMERALD_ORE = MaterialKey.from(49, 64, NamespacedKey.minecraft("deepslate_emerald_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey DEEPSLATE_NETHER_QUARTZ_ORE = MaterialKey.from(50, 64, NamespacedKey.minecraft("deepslate_nether_quartz_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey DEEPSLATE_COPPER_ORE = MaterialKey.from(51, 64, NamespacedKey.minecraft("deepslate_copper_ore"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));


    //register all logs of minecraft 1.19
    public static MaterialKey OAK_LOG = MaterialKey.from(52, 64, NamespacedKey.minecraft("oak_log"), MaterialCategory.LOG, Set.of(MaterialCategory.BLOCK, MaterialCategory.LOG));
    public static MaterialKey SPRUCE_LOG = MaterialKey.from(53, 64, NamespacedKey.minecraft("spruce_log"), MaterialCategory.LOG, Set.of(MaterialCategory.BLOCK, MaterialCategory.LOG));
    public static MaterialKey BIRCH_LOG = MaterialKey.from(54, 64, NamespacedKey.minecraft("birch_log"), MaterialCategory.LOG, Set.of(MaterialCategory.BLOCK, MaterialCategory.LOG));
    public static MaterialKey JUNGLE_LOG = MaterialKey.from(55, 64, NamespacedKey.minecraft("jungle_log"), MaterialCategory.LOG, Set.of(MaterialCategory.BLOCK, MaterialCategory.LOG));
    public static MaterialKey ACACIA_LOG = MaterialKey.from(56, 64, NamespacedKey.minecraft("acacia_log"), MaterialCategory.LOG, Set.of(MaterialCategory.BLOCK, MaterialCategory.LOG));
    public static MaterialKey DARK_OAK_LOG = MaterialKey.from(57, 64, NamespacedKey.minecraft("dark_oak_log"), MaterialCategory.LOG, Set.of(MaterialCategory.BLOCK, MaterialCategory.LOG));


    //register all stairs like cobblestone_stairs, purpur_stairs, etc

    public static MaterialKey OAK_WOOD_STAIRS = MaterialKey.from(58, 64, NamespacedKey.minecraft("oak_wood_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey SPRUCE_WOOD_STAIRS = MaterialKey.from(59, 64, NamespacedKey.minecraft("spruce_wood_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey BIRCH_WOOD_STAIRS = MaterialKey.from(60, 64, NamespacedKey.minecraft("birch_wood_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey JUNGLE_WOOD_STAIRS = MaterialKey.from(61, 64, NamespacedKey.minecraft("jungle_wood_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey ACACIA_WOOD_STAIRS = MaterialKey.from(62, 64, NamespacedKey.minecraft("acacia_wood_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey DARK_OAK_WOOD_STAIRS = MaterialKey.from(63, 64, NamespacedKey.minecraft("dark_oak_wood_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey COBBLESTONE_STAIRS = MaterialKey.from(64, 64, NamespacedKey.minecraft("cobblestone_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey BRICK_STAIRS = MaterialKey.from(65, 64, NamespacedKey.minecraft("brick_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey STONE_BRICK_STAIRS = MaterialKey.from(66, 64, NamespacedKey.minecraft("stone_brick_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey NETHER_BRICK_STAIRS = MaterialKey.from(67, 64, NamespacedKey.minecraft("nether_brick_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey SANDSTONE_STAIRS = MaterialKey.from(68, 64, NamespacedKey.minecraft("sandstone_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey RED_SANDSTONE_STAIRS = MaterialKey.from(69, 64, NamespacedKey.minecraft("red_sandstone_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey QUARTZ_STAIRS = MaterialKey.from(70, 64, NamespacedKey.minecraft("quartz_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey PURPUR_STAIRS = MaterialKey.from(71, 64, NamespacedKey.minecraft("purpur_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey PRISMARINE_STAIRS = MaterialKey.from(72, 64, NamespacedKey.minecraft("prismarine_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey DARK_PRISMARINE_STAIRS = MaterialKey.from(73, 64, NamespacedKey.minecraft("dark_prismarine_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey PRISMARINE_BRICK_STAIRS = MaterialKey.from(74, 64, NamespacedKey.minecraft("prismarine_brick_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey MOSSY_COBBLESTONE_STAIRS = MaterialKey.from(75, 64, NamespacedKey.minecraft("mossy_cobblestone_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey MOSSY_STONE_BRICK_STAIRS = MaterialKey.from(76, 64, NamespacedKey.minecraft("mossy_stone_brick_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey END_STONE_BRICK_STAIRS = MaterialKey.from(77, 64, NamespacedKey.minecraft("end_stone_brick_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey STONE_STAIRS = MaterialKey.from(78, 64, NamespacedKey.minecraft("stone_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey SMOOTH_SANDSTONE_STAIRS = MaterialKey.from(79, 64, NamespacedKey.minecraft("smooth_sandstone_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey SMOOTH_QUARTZ_STAIRS = MaterialKey.from(80, 64, NamespacedKey.minecraft("smooth_quartz_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey GRANITE_STAIRS = MaterialKey.from(81, 64, NamespacedKey.minecraft("granite_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey ANDESITE_STAIRS = MaterialKey.from(82, 64, NamespacedKey.minecraft("andesite_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey RED_NETHER_BRICK_STAIRS = MaterialKey.from(83, 64, NamespacedKey.minecraft("red_nether_brick_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey POLISHED_ANDESITE_STAIRS = MaterialKey.from(84, 64, NamespacedKey.minecraft("polished_andesite_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey DIORITE_STAIRS = MaterialKey.from(85, 64, NamespacedKey.minecraft("diorite_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey POLISHED_DIORITE_STAIRS = MaterialKey.from(86, 64, NamespacedKey.minecraft("polished_diorite_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));
    public static MaterialKey POLISHED_GRANITE_STAIRS = MaterialKey.from(87, 64, NamespacedKey.minecraft("polished_granite_stairs"), MaterialCategory.STAIRS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE));


    //register stripped oak log
    public static MaterialKey STRIPPED_OAK_LOG = MaterialKey.from(88, 64, NamespacedKey.minecraft("stripped_oak_log"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey STRIPPED_SPRUCE_LOG = MaterialKey.from(89, 64, NamespacedKey.minecraft("stripped_spruce_log"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey STRIPPED_BIRCH_LOG = MaterialKey.from(90, 64, NamespacedKey.minecraft("stripped_birch_log"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey STRIPPED_JUNGLE_LOG = MaterialKey.from(91, 64, NamespacedKey.minecraft("stripped_jungle_log"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey STRIPPED_ACACIA_LOG = MaterialKey.from(92, 64, NamespacedKey.minecraft("stripped_acacia_log"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey STRIPPED_DARK_OAK_LOG = MaterialKey.from(93, 64, NamespacedKey.minecraft("stripped_dark_oak_log"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey STRIPPED_OAK_WOOD = MaterialKey.from(94, 64, NamespacedKey.minecraft("stripped_oak_wood"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey STRIPPED_SPRUCE_WOOD = MaterialKey.from(95, 64, NamespacedKey.minecraft("stripped_spruce_wood"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey STRIPPED_BIRCH_WOOD = MaterialKey.from(96, 64, NamespacedKey.minecraft("stripped_birch_wood"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey STRIPPED_JUNGLE_WOOD = MaterialKey.from(97, 64, NamespacedKey.minecraft("stripped_jungle_wood"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey STRIPPED_ACACIA_WOOD = MaterialKey.from(98, 64, NamespacedKey.minecraft("stripped_acacia_wood"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));
    public static MaterialKey STRIPPED_DARK_OAK_WOOD = MaterialKey.from(99, 64, NamespacedKey.minecraft("stripped_dark_oak_wood"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOD));


    //register all leaves
    public static MaterialKey OAK_LEAVES = MaterialKey.from(100, 64, NamespacedKey.minecraft("oak_leaves"), MaterialCategory.LEAVES, Set.of(MaterialCategory.BLOCK, MaterialCategory.LEAVES));
    public static MaterialKey SPRUCE_LEAVES = MaterialKey.from(101, 64, NamespacedKey.minecraft("spruce_leaves"), MaterialCategory.LEAVES, Set.of(MaterialCategory.BLOCK, MaterialCategory.LEAVES));
    public static MaterialKey BIRCH_LEAVES = MaterialKey.from(102, 64, NamespacedKey.minecraft("birch_leaves"), MaterialCategory.LEAVES, Set.of(MaterialCategory.BLOCK, MaterialCategory.LEAVES));
    public static MaterialKey JUNGLE_LEAVES = MaterialKey.from(103, 64, NamespacedKey.minecraft("jungle_leaves"), MaterialCategory.LEAVES, Set.of(MaterialCategory.BLOCK, MaterialCategory.LEAVES));
    public static MaterialKey ACACIA_LEAVES = MaterialKey.from(104, 64, NamespacedKey.minecraft("acacia_leaves"), MaterialCategory.LEAVES, Set.of(MaterialCategory.BLOCK, MaterialCategory.LEAVES));
    public static MaterialKey DARK_OAK_LEAVES = MaterialKey.from(105, 64, NamespacedKey.minecraft("dark_oak_leaves"), MaterialCategory.LEAVES, Set.of(MaterialCategory.BLOCK, MaterialCategory.LEAVES));


    public static MaterialKey SPONGE = MaterialKey.from(106, 64, NamespacedKey.minecraft("sponge"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));
    public static MaterialKey WET_SPONGE = MaterialKey.from(107, 64, NamespacedKey.minecraft("wet_sponge"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));

    //register dispenser
    public static MaterialKey DISPENSER = MaterialKey.from(109, 64, NamespacedKey.minecraft("dispenser"), MaterialCategory.BLOCK, Set.of(MaterialCategory.BLOCK));


    //register button and lever
    public static MaterialKey OAK_BUTTON = MaterialKey.from(110, 64, NamespacedKey.minecraft("oak_button"), MaterialCategory.BUTTON, Set.of(MaterialCategory.BLOCK, MaterialCategory.BUTTON));
    public static MaterialKey SPRUCE_BUTTON = MaterialKey.from(111, 64, NamespacedKey.minecraft("spruce_button"), MaterialCategory.BUTTON, Set.of(MaterialCategory.BLOCK, MaterialCategory.BUTTON));
    public static MaterialKey BIRCH_BUTTON = MaterialKey.from(112, 64, NamespacedKey.minecraft("birch_button"), MaterialCategory.BUTTON, Set.of(MaterialCategory.BLOCK, MaterialCategory.BUTTON));
    public static MaterialKey JUNGLE_BUTTON = MaterialKey.from(113, 64, NamespacedKey.minecraft("jungle_button"), MaterialCategory.BUTTON, Set.of(MaterialCategory.BLOCK, MaterialCategory.BUTTON));
    public static MaterialKey ACACIA_BUTTON = MaterialKey.from(114, 64, NamespacedKey.minecraft("acacia_button"), MaterialCategory.BUTTON, Set.of(MaterialCategory.BLOCK, MaterialCategory.BUTTON));
    public static MaterialKey DARK_OAK_BUTTON = MaterialKey.from(115, 64, NamespacedKey.minecraft("dark_oak_button"), MaterialCategory.BUTTON, Set.of(MaterialCategory.BLOCK, MaterialCategory.BUTTON));
    public static MaterialKey STONE_BUTTON = MaterialKey.from(116, 64, NamespacedKey.minecraft("stone_button"), MaterialCategory.BUTTON, Set.of(MaterialCategory.BLOCK, MaterialCategory.BUTTON));
    public static MaterialKey STONE_LEVER = MaterialKey.from(117, 64, NamespacedKey.minecraft("stone_lever"), MaterialCategory.LEVER, Set.of(MaterialCategory.BLOCK, MaterialCategory.LEVER));


    //register slab all types of 1.19
    public static MaterialKey OAK_SLAB = MaterialKey.from(118, 64, NamespacedKey.minecraft("oak_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey SPRUCE_SLAB = MaterialKey.from(119, 64, NamespacedKey.minecraft("spruce_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey BIRCH_SLAB = MaterialKey.from(120, 64, NamespacedKey.minecraft("birch_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey JUNGLE_SLAB = MaterialKey.from(121, 64, NamespacedKey.minecraft("jungle_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey ACACIA_SLAB = MaterialKey.from(122, 64, NamespacedKey.minecraft("acacia_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey DARK_OAK_SLAB = MaterialKey.from(123, 64, NamespacedKey.minecraft("dark_oak_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey STONE_SLAB = MaterialKey.from(124, 64, NamespacedKey.minecraft("stone_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey SMOOTH_STONE_SLAB = MaterialKey.from(125, 64, NamespacedKey.minecraft("smooth_stone_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey SANDSTONE_SLAB = MaterialKey.from(126, 64, NamespacedKey.minecraft("sandstone_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey CUT_SANDSTONE_SLAB = MaterialKey.from(127, 64, NamespacedKey.minecraft("cut_sandstone_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey PETRIFIED_OAK_SLAB = MaterialKey.from(128, 64, NamespacedKey.minecraft("petrified_oak_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey COBBLESTONE_SLAB = MaterialKey.from(129, 64, NamespacedKey.minecraft("cobblestone_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey BRICK_SLAB = MaterialKey.from(130, 64, NamespacedKey.minecraft("brick_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey STONE_BRICK_SLAB = MaterialKey.from(131, 64, NamespacedKey.minecraft("stone_brick_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey NETHER_BRICK_SLAB = MaterialKey.from(132, 64, NamespacedKey.minecraft("nether_brick_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey QUARTZ_SLAB = MaterialKey.from(133, 64, NamespacedKey.minecraft("quartz_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey RED_SANDSTONE_SLAB = MaterialKey.from(134, 64, NamespacedKey.minecraft("red_sandstone_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey CUT_RED_SANDSTONE_SLAB = MaterialKey.from(135, 64, NamespacedKey.minecraft("cut_red_sandstone_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey PURPUR_SLAB = MaterialKey.from(136, 64, NamespacedKey.minecraft("purpur_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey PRISMARINE_SLAB = MaterialKey.from(137, 64, NamespacedKey.minecraft("prismarine_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey PRISMARINE_BRICK_SLAB = MaterialKey.from(138, 64, NamespacedKey.minecraft("prismarine_brick_slab"), MaterialCategory.SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));


    //register double slab all types of 1.19
    public static MaterialKey DOUBLE_OAK_SLAB = MaterialKey.from(140, 64, NamespacedKey.minecraft("double_oak_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_SPRUCE_SLAB = MaterialKey.from(141, 64, NamespacedKey.minecraft("double_spruce_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_BIRCH_SLAB = MaterialKey.from(142, 64, NamespacedKey.minecraft("double_birch_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_JUNGLE_SLAB = MaterialKey.from(143, 64, NamespacedKey.minecraft("double_jungle_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_ACACIA_SLAB = MaterialKey.from(144, 64, NamespacedKey.minecraft("double_acacia_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_DARK_OAK_SLAB = MaterialKey.from(145, 64, NamespacedKey.minecraft("double_dark_oak_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_STONE_SLAB = MaterialKey.from(146, 64, NamespacedKey.minecraft("double_stone_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_SMOOTH_STONE_SLAB = MaterialKey.from(147, 64, NamespacedKey.minecraft("double_smooth_stone_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_SANDSTONE_SLAB = MaterialKey.from(148, 64, NamespacedKey.minecraft("double_sandstone_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_CUT_SANDSTONE_SLAB = MaterialKey.from(149, 64, NamespacedKey.minecraft("double_cut_sandstone_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_PETRIFIED_OAK_SLAB = MaterialKey.from(150, 64, NamespacedKey.minecraft("double_petrified_oak_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_COBBLESTONE_SLAB = MaterialKey.from(151, 64, NamespacedKey.minecraft("double_cobblestone_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_BRICK_SLAB = MaterialKey.from(152, 64, NamespacedKey.minecraft("double_brick_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_STONE_BRICK_SLAB = MaterialKey.from(153, 64, NamespacedKey.minecraft("double_stone_brick_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_NETHER_BRICK_SLAB = MaterialKey.from(154, 64, NamespacedKey.minecraft("double_nether_brick_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_QUARTZ_SLAB = MaterialKey.from(155, 64, NamespacedKey.minecraft("double_quartz_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_RED_SANDSTONE_SLAB = MaterialKey.from(156, 64, NamespacedKey.minecraft("double_red_sandstone_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_CUT_RED_SANDSTONE_SLAB = MaterialKey.from(157, 64, NamespacedKey.minecraft("double_cut_red_sandstone_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_PURPUR_SLAB = MaterialKey.from(158, 64, NamespacedKey.minecraft("double_purpur_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_PRISMARINE_SLAB = MaterialKey.from(159, 64, NamespacedKey.minecraft("double_prismarine_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_DARK_PRISMARINE_SLAB = MaterialKey.from(160, 64, NamespacedKey.minecraft("double_dark_prismarine_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_PRISMARINE_BRICK_SLAB = MaterialKey.from(161, 64, NamespacedKey.minecraft("double_prismarine_brick_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_MOSSY_COBBLESTONE_SLAB = MaterialKey.from(162, 64, NamespacedKey.minecraft("double_mossy_cobblestone_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_MOSSY_STONE_BRICK_SLAB = MaterialKey.from(163, 64, NamespacedKey.minecraft("double_mossy_stone_brick_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_END_STONE_BRICK_SLAB = MaterialKey.from(164, 64, NamespacedKey.minecraft("double_end_stone_brick_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_GRANITE_SLAB = MaterialKey.from(167, 64, NamespacedKey.minecraft("double_granite_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_ANDESITE_SLAB = MaterialKey.from(168, 64, NamespacedKey.minecraft("double_andesite_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_RED_NETHER_BRICK_SLAB = MaterialKey.from(169, 64, NamespacedKey.minecraft("double_red_nether_brick_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_POLISHED_ANDESITE_SLAB = MaterialKey.from(170, 64, NamespacedKey.minecraft("double_polished_andesite_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_DIORITE_SLAB = MaterialKey.from(171, 64, NamespacedKey.minecraft("double_diorite_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_POLISHED_DIORITE_SLAB = MaterialKey.from(172, 64, NamespacedKey.minecraft("double_polished_diorite_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_POLISHED_GRANITE_SLAB = MaterialKey.from(173, 64, NamespacedKey.minecraft("double_polished_granite_slab"), MaterialCategory.DOUBLE_SLAB, Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));


    //register stained glass with color
    public static MaterialKey GLASS = MaterialKey.from(180, 64, NamespacedKey.minecraft("stained_glass"), MaterialCategory.GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS));
    public static MaterialKey WHITE_STAINED_GLASS = MaterialKey.from(181, 64, NamespacedKey.minecraft("white_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey ORANGE_STAINED_GLASS = MaterialKey.from(182, 64, NamespacedKey.minecraft("orange_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey MAGENTA_STAINED_GLASS = MaterialKey.from(183, 64, NamespacedKey.minecraft("magenta_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey LIGHT_BLUE_STAINED_GLASS = MaterialKey.from(184, 64, NamespacedKey.minecraft("light_blue_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey YELLOW_STAINED_GLASS = MaterialKey.from(185, 64, NamespacedKey.minecraft("yellow_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey LIME_STAINED_GLASS = MaterialKey.from(186, 64, NamespacedKey.minecraft("lime_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey PINK_STAINED_GLASS = MaterialKey.from(187, 64, NamespacedKey.minecraft("pink_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey GRAY_STAINED_GLASS = MaterialKey.from(188, 64, NamespacedKey.minecraft("gray_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey LIGHT_GRAY_STAINED_GLASS = MaterialKey.from(189, 64, NamespacedKey.minecraft("light_gray_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey CYAN_STAINED_GLASS = MaterialKey.from(190, 64, NamespacedKey.minecraft("cyan_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey PURPLE_STAINED_GLASS = MaterialKey.from(191, 64, NamespacedKey.minecraft("purple_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey BLUE_STAINED_GLASS = MaterialKey.from(192, 64, NamespacedKey.minecraft("blue_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey BROWN_STAINED_GLASS = MaterialKey.from(193, 64, NamespacedKey.minecraft("brown_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey GREEN_STAINED_GLASS = MaterialKey.from(194, 64, NamespacedKey.minecraft("green_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey RED_STAINED_GLASS = MaterialKey.from(195, 64, NamespacedKey.minecraft("red_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey BLACK_STAINED_GLASS = MaterialKey.from(196, 64, NamespacedKey.minecraft("black_stained_glass"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));

    //register stained glass pane with color
    public static MaterialKey GLASS_PANE = MaterialKey.from(197, 64, NamespacedKey.minecraft("stained_glass_pane"), MaterialCategory.GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS));
    public static MaterialKey WHITE_STAINED_GLASS_PANE = MaterialKey.from(198, 64, NamespacedKey.minecraft("white_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey ORANGE_STAINED_GLASS_PANE = MaterialKey.from(199, 64, NamespacedKey.minecraft("orange_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey MAGENTA_STAINED_GLASS_PANE = MaterialKey.from(200, 64, NamespacedKey.minecraft("magenta_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey LIGHT_BLUE_STAINED_GLASS_PANE = MaterialKey.from(201, 64, NamespacedKey.minecraft("light_blue_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey YELLOW_STAINED_GLASS_PANE = MaterialKey.from(202, 64, NamespacedKey.minecraft("yellow_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey LIME_STAINED_GLASS_PANE = MaterialKey.from(203, 64, NamespacedKey.minecraft("lime_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey PINK_STAINED_GLASS_PANE = MaterialKey.from(204, 64, NamespacedKey.minecraft("pink_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey GRAY_STAINED_GLASS_PANE = MaterialKey.from(205, 64, NamespacedKey.minecraft("gray_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey LIGHT_GRAY_STAINED_GLASS_PANE = MaterialKey.from(206, 64, NamespacedKey.minecraft("light_gray_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey CYAN_STAINED_GLASS_PANE = MaterialKey.from(207, 64, NamespacedKey.minecraft("cyan_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey PURPLE_STAINED_GLASS_PANE = MaterialKey.from(208, 64, NamespacedKey.minecraft("purple_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey BLUE_STAINED_GLASS_PANE = MaterialKey.from(209, 64, NamespacedKey.minecraft("blue_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey BROWN_STAINED_GLASS_PANE = MaterialKey.from(210, 64, NamespacedKey.minecraft("brown_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey GREEN_STAINED_GLASS_PANE = MaterialKey.from(211, 64, NamespacedKey.minecraft("green_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey RED_STAINED_GLASS_PANE = MaterialKey.from(212, 64, NamespacedKey.minecraft("red_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));
    public static MaterialKey BLACK_STAINED_GLASS_PANE = MaterialKey.from(213, 64, NamespacedKey.minecraft("black_stained_glass_pane"), MaterialCategory.STAINED_GLASS, Set.of(MaterialCategory.BLOCK, MaterialCategory.STAINED_GLASS));

    //register wool with color
    public static MaterialKey WHITE_WOOL = MaterialKey.from(214, 64, NamespacedKey.minecraft("white_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey ORANGE_WOOL = MaterialKey.from(215, 64, NamespacedKey.minecraft("orange_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey MAGENTA_WOOL = MaterialKey.from(216, 64, NamespacedKey.minecraft("magenta_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey LIGHT_BLUE_WOOL = MaterialKey.from(217, 64, NamespacedKey.minecraft("light_blue_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey YELLOW_WOOL = MaterialKey.from(218, 64, NamespacedKey.minecraft("yellow_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey LIME_WOOL = MaterialKey.from(219, 64, NamespacedKey.minecraft("lime_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey PINK_WOOL = MaterialKey.from(220, 64, NamespacedKey.minecraft("pink_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey GRAY_WOOL = MaterialKey.from(221, 64, NamespacedKey.minecraft("gray_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey LIGHT_GRAY_WOOL = MaterialKey.from(222, 64, NamespacedKey.minecraft("light_gray_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey CYAN_WOOL = MaterialKey.from(223, 64, NamespacedKey.minecraft("cyan_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey PURPLE_WOOL = MaterialKey.from(224, 64, NamespacedKey.minecraft("purple_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey BLUE_WOOL = MaterialKey.from(225, 64, NamespacedKey.minecraft("blue_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey BROWN_WOOL = MaterialKey.from(226, 64, NamespacedKey.minecraft("brown_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey GREEN_WOOL = MaterialKey.from(227, 64, NamespacedKey.minecraft("green_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey RED_WOOL = MaterialKey.from(228, 64, NamespacedKey.minecraft("red_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey BLACK_WOOL = MaterialKey.from(229, 64, NamespacedKey.minecraft("black_wool"), MaterialCategory.WOOL, Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));

    //register clay with color
    public static MaterialKey TERRACOTTA = MaterialKey.from(240, 64, NamespacedKey.minecraft("terracotta"), MaterialCategory.CLAY, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY));
    public static MaterialKey WHITE_TERRACOTTA = MaterialKey.from(241, 64, NamespacedKey.minecraft("white_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey ORANGE_TERRACOTTA = MaterialKey.from(242, 64, NamespacedKey.minecraft("orange_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey MAGENTA_TERRACOTTA = MaterialKey.from(243, 64, NamespacedKey.minecraft("magenta_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey LIGHT_BLUE_TERRACOTTA = MaterialKey.from(244, 64, NamespacedKey.minecraft("light_blue_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey YELLOW_TERRACOTTA = MaterialKey.from(245, 64, NamespacedKey.minecraft("yellow_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey LIME_TERRACOTTA = MaterialKey.from(246, 64, NamespacedKey.minecraft("lime_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey PINK_TERRACOTTA = MaterialKey.from(247, 64, NamespacedKey.minecraft("pink_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey GRAY_TERRACOTTA = MaterialKey.from(248, 64, NamespacedKey.minecraft("gray_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey LIGHT_GRAY_TERRACOTTA = MaterialKey.from(249, 64, NamespacedKey.minecraft("light_gray_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey CYAN_TERRACOTTA = MaterialKey.from(250, 64, NamespacedKey.minecraft("cyan_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey PURPLE_TERRACOTTA = MaterialKey.from(251, 64, NamespacedKey.minecraft("purple_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey BLUE_TERRACOTTA = MaterialKey.from(252, 64, NamespacedKey.minecraft("blue_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey BROWN_TERRACOTTA = MaterialKey.from(253, 64, NamespacedKey.minecraft("brown_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey GREEN_TERRACOTTA = MaterialKey.from(254, 64, NamespacedKey.minecraft("green_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey RED_TERRACOTTA = MaterialKey.from(255, 64, NamespacedKey.minecraft("red_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));
    public static MaterialKey BLACK_TERRACOTTA = MaterialKey.from(256, 64, NamespacedKey.minecraft("black_terracotta"), MaterialCategory.TERRACOTTA, Set.of(MaterialCategory.BLOCK, MaterialCategory.CLAY, MaterialCategory.TERRACOTTA));

    //register sand & sandstone
    public static MaterialKey SAND = MaterialKey.from(257, 64, NamespacedKey.minecraft("sand"), MaterialCategory.SAND, Set.of(MaterialCategory.BLOCK, MaterialCategory.SAND));
    public static MaterialKey RED_SAND = MaterialKey.from(258, 64, NamespacedKey.minecraft("red_sand"), MaterialCategory.SAND, Set.of(MaterialCategory.BLOCK, MaterialCategory.SAND));
    public static MaterialKey SANDSTONE = MaterialKey.from(259, 64, NamespacedKey.minecraft("sandstone"), MaterialCategory.SANDSTONE, Set.of(MaterialCategory.BLOCK, MaterialCategory.SANDSTONE));
    public static MaterialKey CHISELED_SANDSTONE = MaterialKey.from(260, 64, NamespacedKey.minecraft("chiseled_sandstone"), MaterialCategory.SANDSTONE, Set.of(MaterialCategory.BLOCK, MaterialCategory.SANDSTONE));
    public static MaterialKey SMOOTH_SANDSTONE = MaterialKey.from(261, 64, NamespacedKey.minecraft("smooth_sandstone"), MaterialCategory.SANDSTONE, Set.of(MaterialCategory.BLOCK, MaterialCategory.SANDSTONE));
    public static MaterialKey SMOOTH_RED_SANDSTONE = MaterialKey.from(262, 64, NamespacedKey.minecraft("smooth_red_sandstone"), MaterialCategory.SANDSTONE, Set.of(MaterialCategory.BLOCK, MaterialCategory.SANDSTONE));
    public static MaterialKey RED_SANDSTONE = MaterialKey.from(263, 64, NamespacedKey.minecraft("red_sandstone"), MaterialCategory.SANDSTONE, Set.of(MaterialCategory.BLOCK, MaterialCategory.SANDSTONE));
    public static MaterialKey CHISELED_RED_SANDSTONE = MaterialKey.from(264, 64, NamespacedKey.minecraft("chiseled_red_sandstone"), MaterialCategory.SANDSTONE, Set.of(MaterialCategory.BLOCK, MaterialCategory.SANDSTONE));


    public static MaterialKey VINE = MaterialKey.from(265, 64, NamespacedKey.minecraft("vine"), MaterialCategory.VINE, Set.of(MaterialCategory.BLOCK, MaterialCategory.VINE));






    /*
    public static MaterialKey STRIPPED_OAK_LOG = MaterialKey.from(41, 64, NamespacedKey.minecraft("stripped_oak_log"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey STRIPPED_SPRUCE_LOG = MaterialKey.from(42, 64, NamespacedKey.minecraft("stripped_spruce_log"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey STRIPPED_BIRCH_LOG = MaterialKey.from(43, 64, NamespacedKey.minecraft("stripped_birch_log"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey STRIPPED_JUNGLE_LOG = MaterialKey.from(44, 64, NamespacedKey.minecraft("stripped_jungle_log"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey STRIPPED_ACACIA_LOG = MaterialKey.from(45, 64, NamespacedKey.minecraft("stripped_acacia_log"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey STRIPPED_DARK_OAK_LOG = MaterialKey.from(46, 64, NamespacedKey.minecraft("stripped_dark_oak_log"), Set.of(MaterialCategory.BLOCK));

    public static MaterialKey OAK_LEAVES = MaterialKey.from(47, 64, NamespacedKey.minecraft("oak_leaves"), Set.of(MaterialCategory.BLOCK, MaterialCategory.LEAVES));
    public static MaterialKey SPRUCE_LEAVES = MaterialKey.from(48, 64, NamespacedKey.minecraft("spruce_leaves"), Set.of(MaterialCategory.BLOCK, MaterialCategory.LEAVES));
    public static MaterialKey BIRCH_LEAVES = MaterialKey.from(49, 64, NamespacedKey.minecraft("birch_leaves"), Set.of(MaterialCategory.BLOCK, MaterialCategory.LEAVES));
    public static MaterialKey JUNGLE_LEAVES = MaterialKey.from(50, 64, NamespacedKey.minecraft("jungle_leaves"), Set.of(MaterialCategory.BLOCK, MaterialCategory.LEAVES));
    public static MaterialKey ACACIA_LEAVES = MaterialKey.from(51, 64, NamespacedKey.minecraft("acacia_leaves"), Set.of(MaterialCategory.BLOCK, MaterialCategory.LEAVES));
    public static MaterialKey DARK_OAK_LEAVES = MaterialKey.from(52, 64, NamespacedKey.minecraft("dark_oak_leaves"), Set.of(MaterialCategory.BLOCK, MaterialCategory.LEAVES));

    public static MaterialKey SPONGE = MaterialKey.from(53, 64, NamespacedKey.minecraft("sponge"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey WET_SPONGE = MaterialKey.from(54, 64, NamespacedKey.minecraft("wet_sponge"), Set.of(MaterialCategory.BLOCK));

    public static MaterialKey GLASS = MaterialKey.from(55, 64, NamespacedKey.minecraft("glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS));
    public static MaterialKey LAPIS_BLOCK = MaterialKey.from(56, 64, NamespacedKey.minecraft("lapis_block"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DISPENSER = MaterialKey.from(57, 64, NamespacedKey.minecraft("dispenser"), Set.of(MaterialCategory.BLOCK));

    public static MaterialKey SANDSTONE = MaterialKey.from(58, 64, NamespacedKey.minecraft("sandstone"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey CHISELED_SANDSTONE = MaterialKey.from(59, 64, NamespacedKey.minecraft("chiseled_sandstone"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey SMOOTH_SANDSTONE = MaterialKey.from(60, 64, NamespacedKey.minecraft("smooth_sandstone"), Set.of(MaterialCategory.BLOCK));

    public static MaterialKey NOTE_BLOCK = MaterialKey.from(61, 64, NamespacedKey.minecraft("note_block"), Set.of(MaterialCategory.BLOCK));

    public static MaterialKey WHITE_BED = MaterialKey.from(62, 64, NamespacedKey.minecraft("white_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey ORANGE_BED = MaterialKey.from(63, 64, NamespacedKey.minecraft("orange_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey MAGENTA_BED = MaterialKey.from(64, 64, NamespacedKey.minecraft("magenta_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey LIGHT_BLUE_BED = MaterialKey.from(65, 64, NamespacedKey.minecraft("light_blue_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey YELLOW_BED = MaterialKey.from(66, 64, NamespacedKey.minecraft("yellow_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey LIME_BED = MaterialKey.from(67, 64, NamespacedKey.minecraft("lime_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey PINK_BED = MaterialKey.from(68, 64, NamespacedKey.minecraft("pink_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey GRAY_BED = MaterialKey.from(69, 64, NamespacedKey.minecraft("gray_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey LIGHT_GRAY_BED = MaterialKey.from(70, 64, NamespacedKey.minecraft("light_gray_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey CYAN_BED = MaterialKey.from(71, 64, NamespacedKey.minecraft("cyan_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey PURPLE_BED = MaterialKey.from(72, 64, NamespacedKey.minecraft("purple_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey BLUE_BED = MaterialKey.from(73, 64, NamespacedKey.minecraft("blue_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey BROWN_BED = MaterialKey.from(74, 64, NamespacedKey.minecraft("brown_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey GREEN_BED = MaterialKey.from(75, 64, NamespacedKey.minecraft("green_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey RED_BED = MaterialKey.from(76, 64, NamespacedKey.minecraft("red_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));
    public static MaterialKey BLACK_BED = MaterialKey.from(77, 64, NamespacedKey.minecraft("black_bed"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BED));

    public static MaterialKey POWERED_RAIL = MaterialKey.from(78, 64, NamespacedKey.minecraft("powered_rail"), Set.of(MaterialCategory.BLOCK, MaterialCategory.RAIL));
    public static MaterialKey DETECTOR_RAIL = MaterialKey.from(79, 64, NamespacedKey.minecraft("detector_rail"), Set.of(MaterialCategory.BLOCK, MaterialCategory.RAIL));
    public static MaterialKey STICKY_PISTON = MaterialKey.from(80, 64, NamespacedKey.minecraft("sticky_piston"), Set.of(MaterialCategory.BLOCK, MaterialCategory.PISTON));
    public static MaterialKey COBWEB = MaterialKey.from(81, 64, NamespacedKey.minecraft("cobweb"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WEB));

    public static MaterialKey DEAD_SHRUB = MaterialKey.from(82, 64, NamespacedKey.minecraft("dead_shrub"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey TALL_GRASS = MaterialKey.from(83, 64, NamespacedKey.minecraft("tall_grass"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey FERN = MaterialKey.from(84, 64, NamespacedKey.minecraft("fern"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DEAD_BUSH = MaterialKey.from(85, 64, NamespacedKey.minecraft("dead_bush"), Set.of(MaterialCategory.BLOCK));

    public static MaterialKey PISTON = MaterialKey.from(86, 64, NamespacedKey.minecraft("piston"), Set.of(MaterialCategory.BLOCK, MaterialCategory.PISTON));
    public static MaterialKey PISTON_HEAD = MaterialKey.from(87, 64, NamespacedKey.minecraft("piston_head"), Set.of(MaterialCategory.BLOCK, MaterialCategory.PISTON));

    // wool with colors
    public static MaterialKey WHITE_WOOL = MaterialKey.from(88, 64, NamespacedKey.minecraft("white_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey ORANGE_WOOL = MaterialKey.from(89, 64, NamespacedKey.minecraft("orange_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey MAGENTA_WOOL = MaterialKey.from(90, 64, NamespacedKey.minecraft("magenta_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey LIGHT_BLUE_WOOL = MaterialKey.from(91, 64, NamespacedKey.minecraft("light_blue_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey YELLOW_WOOL = MaterialKey.from(92, 64, NamespacedKey.minecraft("yellow_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey LIME_WOOL = MaterialKey.from(93, 64, NamespacedKey.minecraft("lime_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey PINK_WOOL = MaterialKey.from(94, 64, NamespacedKey.minecraft("pink_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey GRAY_WOOL = MaterialKey.from(95, 64, NamespacedKey.minecraft("gray_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey LIGHT_GRAY_WOOL = MaterialKey.from(96, 64, NamespacedKey.minecraft("light_gray_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey CYAN_WOOL = MaterialKey.from(97, 64, NamespacedKey.minecraft("cyan_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey PURPLE_WOOL = MaterialKey.from(98, 64, NamespacedKey.minecraft("purple_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey BLUE_WOOL = MaterialKey.from(99, 64, NamespacedKey.minecraft("blue_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey BROWN_WOOL = MaterialKey.from(100, 64, NamespacedKey.minecraft("brown_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey GREEN_WOOL = MaterialKey.from(101, 64, NamespacedKey.minecraft("green_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey RED_WOOL = MaterialKey.from(102, 64, NamespacedKey.minecraft("red_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));
    public static MaterialKey BLACK_WOOL = MaterialKey.from(103, 64, NamespacedKey.minecraft("black_wool"), Set.of(MaterialCategory.BLOCK, MaterialCategory.WOOL));

    public static MaterialKey DANDELION = MaterialKey.from(104, 64, NamespacedKey.minecraft("dandelion"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey POPPY = MaterialKey.from(105, 64, NamespacedKey.minecraft("poppy"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey BLUE_ORCHID = MaterialKey.from(106, 64, NamespacedKey.minecraft("blue_orchid"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey ALLIUM = MaterialKey.from(107, 64, NamespacedKey.minecraft("allium"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey AZURE_BLUET = MaterialKey.from(108, 64, NamespacedKey.minecraft("azure_bluet"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey RED_TULIP = MaterialKey.from(109, 64, NamespacedKey.minecraft("red_tulip"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey ORANGE_TULIP = MaterialKey.from(110, 64, NamespacedKey.minecraft("orange_tulip"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey WHITE_TULIP = MaterialKey.from(111, 64, NamespacedKey.minecraft("white_tulip"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey PINK_TULIP = MaterialKey.from(112, 64, NamespacedKey.minecraft("pink_tulip"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey OXEYE_DAISY = MaterialKey.from(113, 64, NamespacedKey.minecraft("oxeye_daisy"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey CORNFLOWER = MaterialKey.from(114, 64, NamespacedKey.minecraft("cornflower"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey LILY_OF_THE_VALLEY = MaterialKey.from(115, 64, NamespacedKey.minecraft("lily_of_the_valley"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey WITHER_ROSE = MaterialKey.from(116, 64, NamespacedKey.minecraft("wither_rose"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));

    public static MaterialKey BROWN_MUSHROOM = MaterialKey.from(117, 64, NamespacedKey.minecraft("brown_mushroom"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));
    public static MaterialKey RED_MUSHROOM = MaterialKey.from(118, 64, NamespacedKey.minecraft("red_mushroom"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FLOWER));

    public static MaterialKey GOLD_BLOCK = MaterialKey.from(119, 64, NamespacedKey.minecraft("gold_block"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey IRON_BLOCK = MaterialKey.from(120, 64, NamespacedKey.minecraft("iron_block"), Set.of(MaterialCategory.BLOCK));

    public static MaterialKey DOUBLE_STONE_SLAB = MaterialKey.from(121, 64, NamespacedKey.minecraft("double_stone_slab"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DOUBLE_SANDSTONE_SLAB = MaterialKey.from(122, 64, NamespacedKey.minecraft("double_sandstone_slab"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DOUBLE_WOODEN_SLAB = MaterialKey.from(123, 64, NamespacedKey.minecraft("double_wooden_slab"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DOUBLE_COBBLESTONE_SLAB = MaterialKey.from(124, 64, NamespacedKey.minecraft("double_cobblestone_slab"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DOUBLE_BRICK_SLAB = MaterialKey.from(125, 64, NamespacedKey.minecraft("double_brick_slab"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DOUBLE_STONE_BRICK_SLAB = MaterialKey.from(126, 64, NamespacedKey.minecraft("double_stone_brick_slab"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DOUBLE_NETHER_BRICK_SLAB = MaterialKey.from(127, 64, NamespacedKey.minecraft("double_nether_brick_slab"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DOUBLE_QUARTZ_SLAB = MaterialKey.from(128, 64, NamespacedKey.minecraft("double_quartz_slab"), Set.of(MaterialCategory.BLOCK));

    public static MaterialKey STONE_SLAB = MaterialKey.from(129, 64, NamespacedKey.minecraft("stone_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey SANDSTONE_SLAB = MaterialKey.from(130, 64, NamespacedKey.minecraft("sandstone_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey WOODEN_SLAB = MaterialKey.from(131, 64, NamespacedKey.minecraft("wooden_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey COBBLESTONE_SLAB = MaterialKey.from(132, 64, NamespacedKey.minecraft("cobblestone_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey BRICK_SLAB = MaterialKey.from(133, 64, NamespacedKey.minecraft("brick_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey STONE_BRICK_SLAB = MaterialKey.from(134, 64, NamespacedKey.minecraft("stone_brick_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey NETHER_BRICK_SLAB = MaterialKey.from(135, 64, NamespacedKey.minecraft("nether_brick_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey QUARTZ_SLAB = MaterialKey.from(136, 64, NamespacedKey.minecraft("quartz_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));

    public static MaterialKey BRICKS = MaterialKey.from(137, 64, NamespacedKey.minecraft("bricks"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey TNT = MaterialKey.from(138, 64, NamespacedKey.minecraft("tnt"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey BOOKSHELF = MaterialKey.from(139, 64, NamespacedKey.minecraft("bookshelf"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey MOSSY_COBBLESTONE = MaterialKey.from(140, 64, NamespacedKey.minecraft("mossy_cobblestone"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey OBSIDIAN = MaterialKey.from(141, 64, NamespacedKey.minecraft("obsidian"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey TORCH = MaterialKey.from(142, 64, NamespacedKey.minecraft("torch"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey FIRE = MaterialKey.from(143, 64, NamespacedKey.minecraft("fire"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey MOB_SPAWNER = MaterialKey.from(144, 64, NamespacedKey.minecraft("mob_spawner"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey OAK_WOOD_STAIRS = MaterialKey.from(145, 64, NamespacedKey.minecraft("oak_wood_stairs"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STAIRS));
    public static MaterialKey CHEST = MaterialKey.from(146, 64, NamespacedKey.minecraft("chest"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey REDSTONE_WIRE = MaterialKey.from(147, 64, NamespacedKey.minecraft("redstone_wire"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DIAMOND_ORE = MaterialKey.from(148, 64, NamespacedKey.minecraft("diamond_ore"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DIAMOND_BLOCK = MaterialKey.from(149, 64, NamespacedKey.minecraft("diamond_block"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey CRAFTING_TABLE = MaterialKey.from(150, 64, NamespacedKey.minecraft("crafting_table"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey WHEAT = MaterialKey.from(151, 64, NamespacedKey.minecraft("wheat"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey FARMLAND = MaterialKey.from(152, 64, NamespacedKey.minecraft("farmland"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey FURNACE = MaterialKey.from(153, 64, NamespacedKey.minecraft("furnace"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey LIT_FURNACE = MaterialKey.from(154, 64, NamespacedKey.minecraft("lit_furnace"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey STANDING_SIGN = MaterialKey.from(155, 64, NamespacedKey.minecraft("standing_sign"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey OAK_DOOR = MaterialKey.from(156, 64, NamespacedKey.minecraft("oak_door"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey LADDER = MaterialKey.from(157, 64, NamespacedKey.minecraft("ladder"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey RAIL = MaterialKey.from(158, 64, NamespacedKey.minecraft("rail"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey COBBLESTONE_STAIRS = MaterialKey.from(159, 64, NamespacedKey.minecraft("cobblestone_stairs"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STAIRS));
    public static MaterialKey WALL_SIGN = MaterialKey.from(160, 64, NamespacedKey.minecraft("wall_sign"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey LEVER = MaterialKey.from(161, 64, NamespacedKey.minecraft("lever"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey STONE_PRESSURE_PLATE = MaterialKey.from(162, 64, NamespacedKey.minecraft("stone_pressure_plate"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey IRON_DOOR = MaterialKey.from(163, 64, NamespacedKey.minecraft("iron_door"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey OAK_PRESSURE_PLATE = MaterialKey.from(164, 64, NamespacedKey.minecraft("oak_pressure_plate"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey REDSTONE_ORE = MaterialKey.from(165, 64, NamespacedKey.minecraft("redstone_ore"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey LIT_REDSTONE_ORE = MaterialKey.from(166, 64, NamespacedKey.minecraft("lit_redstone_ore"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey UNLIT_REDSTONE_TORCH = MaterialKey.from(167, 64, NamespacedKey.minecraft("unlit_redstone_torch"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey REDSTONE_TORCH = MaterialKey.from(168, 64, NamespacedKey.minecraft("redstone_torch"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey STONE_BUTTON = MaterialKey.from(169, 64, NamespacedKey.minecraft("stone_button"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey SNOW = MaterialKey.from(170, 64, NamespacedKey.minecraft("snow"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey ICE = MaterialKey.from(171, 64, NamespacedKey.minecraft("ice"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey SNOW_BLOCK = MaterialKey.from(172, 64, NamespacedKey.minecraft("snow_block"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey CACTUS = MaterialKey.from(173, 64, NamespacedKey.minecraft("cactus"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey CLAY = MaterialKey.from(174, 64, NamespacedKey.minecraft("clay"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey SUGAR_CANE = MaterialKey.from(175, 64, NamespacedKey.minecraft("sugar_cane"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey JUKEBOX = MaterialKey.from(176, 64, NamespacedKey.minecraft("jukebox"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey OAK_FENCE = MaterialKey.from(177, 64, NamespacedKey.minecraft("oak_fence"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey PUMPKIN = MaterialKey.from(178, 64, NamespacedKey.minecraft("pumpkin"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey NETHERRACK = MaterialKey.from(179, 64, NamespacedKey.minecraft("netherrack"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey SOUL_SAND = MaterialKey.from(180, 64, NamespacedKey.minecraft("soul_sand"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey GLOWSTONE = MaterialKey.from(181, 64, NamespacedKey.minecraft("glowstone"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey NETHER_PORTAL = MaterialKey.from(182, 64, NamespacedKey.minecraft("portal"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey JACK_O_LANTERN = MaterialKey.from(183, 64, NamespacedKey.minecraft("jack_o_lantern"), Set.of(MaterialCategory.BLOCK, MaterialCategory.MELON));
    public static MaterialKey CAKE = MaterialKey.from(184, 64, NamespacedKey.minecraft("cake"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FOOD));
    public static MaterialKey UNPOWERED_REPEATER = MaterialKey.from(185, 64, NamespacedKey.minecraft("unpowered_repeater"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey POWERED_REPEATER = MaterialKey.from(186, 64, NamespacedKey.minecraft("powered_repeater"), Set.of(MaterialCategory.BLOCK));

    // register Stained glass with colors
    public static MaterialKey WHITE_STAINED_GLASS = MaterialKey.from(187, 64, NamespacedKey.minecraft("white_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey ORANGE_STAINED_GLASS = MaterialKey.from(188, 64, NamespacedKey.minecraft("orange_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey MAGENTA_STAINED_GLASS = MaterialKey.from(189, 64, NamespacedKey.minecraft("magenta_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey LIGHT_BLUE_STAINED_GLASS = MaterialKey.from(190, 64, NamespacedKey.minecraft("light_blue_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey YELLOW_STAINED_GLASS = MaterialKey.from(191, 64, NamespacedKey.minecraft("yellow_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey LIME_STAINED_GLASS = MaterialKey.from(192, 64, NamespacedKey.minecraft("lime_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey PINK_STAINED_GLASS = MaterialKey.from(193, 64, NamespacedKey.minecraft("pink_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey GRAY_STAINED_GLASS = MaterialKey.from(194, 64, NamespacedKey.minecraft("gray_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey LIGHT_GRAY_STAINED_GLASS = MaterialKey.from(195, 64, NamespacedKey.minecraft("light_gray_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey CYAN_STAINED_GLASS = MaterialKey.from(196, 64, NamespacedKey.minecraft("cyan_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey PURPLE_STAINED_GLASS = MaterialKey.from(197, 64, NamespacedKey.minecraft("purple_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey BLUE_STAINED_GLASS = MaterialKey.from(198, 64, NamespacedKey.minecraft("blue_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey BROWN_STAINED_GLASS = MaterialKey.from(199, 64, NamespacedKey.minecraft("brown_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey GREEN_STAINED_GLASS = MaterialKey.from(200, 64, NamespacedKey.minecraft("green_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey RED_STAINED_GLASS = MaterialKey.from(201, 64, NamespacedKey.minecraft("red_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));
    public static MaterialKey BLACK_STAINED_GLASS = MaterialKey.from(202, 64, NamespacedKey.minecraft("black_stained_glass"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.STAINED_GLASS));

    public static MaterialKey OAK_TRAPDOOR = MaterialKey.from(203, 64, NamespacedKey.minecraft("oak_trapdoor"), Set.of(MaterialCategory.BLOCK, MaterialCategory.TRAPDOOR));
    public static MaterialKey SPRUCE_TRAPDOOR = MaterialKey.from(204, 64, NamespacedKey.minecraft("spruce_trapdoor"), Set.of(MaterialCategory.BLOCK, MaterialCategory.TRAPDOOR));
    public static MaterialKey BIRCH_TRAPDOOR = MaterialKey.from(205, 64, NamespacedKey.minecraft("birch_trapdoor"), Set.of(MaterialCategory.BLOCK, MaterialCategory.TRAPDOOR));
    public static MaterialKey JUNGLE_TRAPDOOR = MaterialKey.from(206, 64, NamespacedKey.minecraft("jungle_trapdoor"), Set.of(MaterialCategory.BLOCK, MaterialCategory.TRAPDOOR));
    public static MaterialKey ACACIA_TRAPDOOR = MaterialKey.from(207, 64, NamespacedKey.minecraft("acacia_trapdoor"), Set.of(MaterialCategory.BLOCK, MaterialCategory.TRAPDOOR));
    public static MaterialKey DARK_OAK_TRAPDOOR = MaterialKey.from(208, 64, NamespacedKey.minecraft("dark_oak_trapdoor"), Set.of(MaterialCategory.BLOCK, MaterialCategory.TRAPDOOR));

    public static MaterialKey STONE_MONSTER_EGG = MaterialKey.from(209, 64, NamespacedKey.minecraft("stone_monster_egg"), Set.of(MaterialCategory.BLOCK, MaterialCategory.MONSTER_EGG));
    public static MaterialKey COBBLESTONE_MONSTER_EGG = MaterialKey.from(210, 64, NamespacedKey.minecraft("cobblestone_monster_egg"), Set.of(MaterialCategory.BLOCK, MaterialCategory.MONSTER_EGG));
    public static MaterialKey STONE_BRICK_MONSTER_EGG = MaterialKey.from(211, 64, NamespacedKey.minecraft("stone_brick_monster_egg"), Set.of(MaterialCategory.BLOCK, MaterialCategory.MONSTER_EGG));
    public static MaterialKey MOSSY_STONE_BRICK_MONSTER_EGG = MaterialKey.from(212, 64, NamespacedKey.minecraft("mossy_stone_brick_monster_egg"), Set.of(MaterialCategory.BLOCK, MaterialCategory.MONSTER_EGG));
    public static MaterialKey CRACKED_STONE_BRICK_MONSTER_EGG = MaterialKey.from(213, 64, NamespacedKey.minecraft("cracked_stone_brick_monster_egg"), Set.of(MaterialCategory.BLOCK, MaterialCategory.MONSTER_EGG));
    public static MaterialKey CHISELED_STONE_BRICK_MONSTER_EGG = MaterialKey.from(214, 64, NamespacedKey.minecraft("chiseled_stone_brick_monster_egg"), Set.of(MaterialCategory.BLOCK, MaterialCategory.MONSTER_EGG));

    public static MaterialKey STONE_BRICK = MaterialKey.from(215, 64, NamespacedKey.minecraft("stone_brick"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE_BRICK));
    public static MaterialKey MOSSY_STONE_BRICK = MaterialKey.from(216, 64, NamespacedKey.minecraft("mossy_stone_brick"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE_BRICK));
    public static MaterialKey CRACKED_STONE_BRICK = MaterialKey.from(217, 64, NamespacedKey.minecraft("cracked_stone_brick"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE_BRICK));
    public static MaterialKey CHISELED_STONE_BRICK = MaterialKey.from(218, 64, NamespacedKey.minecraft("chiseled_stone_brick"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STONE_BRICK));

    public static MaterialKey BROWN_MUSHROOM_BLOCK = MaterialKey.from(219, 64, NamespacedKey.minecraft("brown_mushroom_block"), Set.of(MaterialCategory.BLOCK, MaterialCategory.MUSHROOM));
    public static MaterialKey RED_MUSHROOM_BLOCK = MaterialKey.from(220, 64, NamespacedKey.minecraft("red_mushroom_block"), Set.of(MaterialCategory.BLOCK, MaterialCategory.MUSHROOM));

    public static MaterialKey IRON_BARS = MaterialKey.from(221, 64, NamespacedKey.minecraft("iron_bars"), Set.of(MaterialCategory.BLOCK, MaterialCategory.BARS));
    public static MaterialKey GLASS_PANE = MaterialKey.from(222, 64, NamespacedKey.minecraft("glass_pane"), Set.of(MaterialCategory.BLOCK, MaterialCategory.GLASS, MaterialCategory.PANE));
    public static MaterialKey MELON_BLOCK = MaterialKey.from(223, 64, NamespacedKey.minecraft("melon_block"), Set.of(MaterialCategory.BLOCK, MaterialCategory.MELON));
    public static MaterialKey PUMPKIN_STEM = MaterialKey.from(224, 64, NamespacedKey.minecraft("pumpkin_stem"), Set.of(MaterialCategory.BLOCK, MaterialCategory.PUMPKIN));
    public static MaterialKey MELON_STEM = MaterialKey.from(225, 64, NamespacedKey.minecraft("melon_stem"), Set.of(MaterialCategory.BLOCK, MaterialCategory.MELON));
    public static MaterialKey VINE = MaterialKey.from(226, 64, NamespacedKey.minecraft("vine"), Set.of(MaterialCategory.BLOCK, MaterialCategory.VINE));

    public static MaterialKey OAK_FENCE_GATE = MaterialKey.from(227, 64, NamespacedKey.minecraft("oak_fence_gate"), Set.of(MaterialCategory.BLOCK, MaterialCategory.FENCE_GATE));
    public static MaterialKey BRICK_STAIRS = MaterialKey.from(228, 64, NamespacedKey.minecraft("brick_stairs"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STAIRS));
    public static MaterialKey STONE_BRICK_STAIRS = MaterialKey.from(229, 64, NamespacedKey.minecraft("stone_brick_stairs"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STAIRS));
    public static MaterialKey MYCELIUM = MaterialKey.from(230, 64, NamespacedKey.minecraft("mycelium"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey LILY_PAD = MaterialKey.from(231, 64, NamespacedKey.minecraft("lily_pad"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey NETHER_BRICK = MaterialKey.from(232, 64, NamespacedKey.minecraft("nether_brick"), Set.of(MaterialCategory.BLOCK, MaterialCategory.NETHER));
    public static MaterialKey NETHER_BRICK_FENCE = MaterialKey.from(233, 64, NamespacedKey.minecraft("nether_brick_fence"), Set.of(MaterialCategory.BLOCK, MaterialCategory.NETHER));
    public static MaterialKey NETHER_BRICK_STAIRS = MaterialKey.from(234, 64, NamespacedKey.minecraft("nether_brick_stairs"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STAIRS));
    public static MaterialKey NETHER_WART = MaterialKey.from(235, 64, NamespacedKey.minecraft("nether_wart"), Set.of(MaterialCategory.BLOCK, MaterialCategory.NETHER));
    public static MaterialKey ENCHANTING_TABLE = MaterialKey.from(236, 64, NamespacedKey.minecraft("enchanting_table"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey BREWING_STAND = MaterialKey.from(237, 64, NamespacedKey.minecraft("brewing_stand"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey CAULDRON = MaterialKey.from(238, 64, NamespacedKey.minecraft("cauldron"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey END_PORTAL = MaterialKey.from(239, 64, NamespacedKey.minecraft("end_portal"), Set.of(MaterialCategory.BLOCK, MaterialCategory.END));
    public static MaterialKey END_PORTAL_FRAME = MaterialKey.from(240, 64, NamespacedKey.minecraft("end_portal_frame"), Set.of(MaterialCategory.BLOCK, MaterialCategory.END));
    public static MaterialKey END_STONE = MaterialKey.from(241, 64, NamespacedKey.minecraft("end_stone"), Set.of(MaterialCategory.BLOCK, MaterialCategory.END));
    public static MaterialKey DRAGON_EGG = MaterialKey.from(242, 64, NamespacedKey.minecraft("dragon_egg"), Set.of(MaterialCategory.BLOCK, MaterialCategory.END));
    public static MaterialKey REDSTONE_LAMP = MaterialKey.from(243, 64, NamespacedKey.minecraft("redstone_lamp"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey LIT_REDSTONE_LAMP = MaterialKey.from(244, 64, NamespacedKey.minecraft("lit_redstone_lamp"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DOUBLE_OAK_SLAB = MaterialKey.from(245, 64, NamespacedKey.minecraft("double_oak_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_SPRUCE_SLAB = MaterialKey.from(246, 64, NamespacedKey.minecraft("double_spruce_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_BIRCH_SLAB = MaterialKey.from(247, 64, NamespacedKey.minecraft("double_birch_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_JUNGLE_SLAB = MaterialKey.from(248, 64, NamespacedKey.minecraft("double_jungle_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_ACACIA_SLAB = MaterialKey.from(249, 64, NamespacedKey.minecraft("double_acacia_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));
    public static MaterialKey DOUBLE_DARK_OAK_SLAB = MaterialKey.from(250, 64, NamespacedKey.minecraft("double_dark_oak_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.DOUBLE_SLAB));

    public static MaterialKey OAK_SLAB = MaterialKey.from(251, 64, NamespacedKey.minecraft("oak_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey SPRUCE_SLAB = MaterialKey.from(252, 64, NamespacedKey.minecraft("spruce_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey BIRCH_SLAB = MaterialKey.from(253, 64, NamespacedKey.minecraft("birch_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey JUNGLE_SLAB = MaterialKey.from(254, 64, NamespacedKey.minecraft("jungle_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey ACACIA_SLAB = MaterialKey.from(255, 64, NamespacedKey.minecraft("acacia_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));
    public static MaterialKey DARK_OAK_SLAB = MaterialKey.from(256, 64, NamespacedKey.minecraft("dark_oak_slab"), Set.of(MaterialCategory.BLOCK, MaterialCategory.SLAB));

    public static MaterialKey COCOA = MaterialKey.from(257, 64, NamespacedKey.minecraft("cocoa"), Set.of(MaterialCategory.BLOCK, MaterialCategory.PLANT));
    public static MaterialKey SANDSTONE_STAIRS = MaterialKey.from(259, 64, NamespacedKey.minecraft("sandstone_stairs"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STAIRS));
    public static MaterialKey EMERALD_ORE = MaterialKey.from(263, 64, NamespacedKey.minecraft("emerald_ore"), Set.of(MaterialCategory.BLOCK, MaterialCategory.ORE));
    public static MaterialKey ENDER_CHEST = MaterialKey.from(264, 64, NamespacedKey.minecraft("ender_chest"), Set.of(MaterialCategory.BLOCK, MaterialCategory.END));
    public static MaterialKey TRIPWIRE_HOOK = MaterialKey.from(265, 64, NamespacedKey.minecraft("tripwire_hook"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey TRIPWIRE = MaterialKey.from(266, 64, NamespacedKey.minecraft("tripwire"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey EMERALD_BLOCK = MaterialKey.from(267, 64, NamespacedKey.minecraft("emerald_block"), Set.of(MaterialCategory.BLOCK, MaterialCategory.END));
    public static MaterialKey SPRUCE_STAIRS = MaterialKey.from(268, 64, NamespacedKey.minecraft("spruce_stairs"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STAIRS));
    public static MaterialKey BIRCH_STAIRS = MaterialKey.from(269, 64, NamespacedKey.minecraft("birch_stairs"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STAIRS));
    public static MaterialKey JUNGLE_STAIRS = MaterialKey.from(270, 64, NamespacedKey.minecraft("jungle_stairs"), Set.of(MaterialCategory.BLOCK, MaterialCategory.STAIRS));


    public static MaterialKey HAY_BLOCK = MaterialKey.from(271, 64, NamespacedKey.minecraft("hay_block"), Set.of(MaterialCategory.BLOCK));

     */


    /*
    public static MaterialKey OAK_WOOD = MaterialKey.from(14, 64, NamespacedKey.minecraft("oak_wood"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey SPRUCE_WOOD = MaterialKey.from(15, 64, NamespacedKey.minecraft("spruce_wood"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey BIRCH_WOOD = MaterialKey.from(16, 64, NamespacedKey.minecraft("birch_wood"), Set.of(MaterialCategory.BLOCK));

     */


    /**
     * Item tested with metadata
     */

    /*
    public static MaterialKey WOODEN_PICKAXE = MaterialKey.from(15, 1, NamespacedKey.minecraft("wooden_pickaxe"), Set.of(MaterialCategory.TOOLS));
    public static MaterialKey LEATHER_HELMET = MaterialKey.from(16, 1, NamespacedKey.minecraft("leather_helmet"), Set.of(MaterialCategory.ARMOR));
    public static MaterialKey PLAYER_HEAD = MaterialKey.from(17, 64, NamespacedKey.minecraft("player_head"), Set.of(MaterialCategory.BLOCK));

     */


    static {
        Field[] declaredFields = Material.class.getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                Object o = field.get(null);
                if (o instanceof MaterialKey materialKey) {
                    LOGGER.debug("Register " + materialKey);
//                    MATERIAL_KEY_BY_NAMESPACED_KEY.put(materialKey.getNamespacedKey(), materialKey);
                    registerMaterialKey(materialKey);
                }
            }
        } catch (IllegalAccessException e) {
            LOGGER.error("", e);
        }

        LOGGER.info("Register {} materialKeys", MATERIAL_BY_ID.size());
    }

    public static NamespacedKey getNamespacedKeyOfMaterialKey(int id, int data) {
        return NAMESPACED_BY_MATERIAL.get(key(id, data));
    }

    public static MaterialKey fromId(int id) {
        return MATERIAL_BY_ID.get(id);
    }

    public static Collection<MaterialKey> getRegisteredMaterials() {
        return MATERIAL_BY_ID.values();
    }

    public static void registerMaterialKey(MaterialKey materialKey) {
        MATERIAL_BY_ID.put(materialKey.getId(), materialKey);
        NAMESPACED_BY_MATERIAL.put(key(materialKey), materialKey.getNamespacedKey());
        for (MaterialCategoryKey materialCategoryKey : materialKey.getMaterialCategoryKeys()) {
            MATERIAL_KEYS_BY_CATEGORY.computeIfAbsent(materialCategoryKey, k -> new HashSet<>()).add(materialKey);
        }
    }

    private static String key(MaterialKey materialKey) {
        return key(materialKey.getId(), materialKey.getMetadata());
    }

    private static String key(int id, int metadata) {
        return id + ":" + metadata;
    }

}

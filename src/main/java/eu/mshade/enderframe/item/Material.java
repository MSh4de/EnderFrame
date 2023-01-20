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
    private final static Map<NamespacedKey, MaterialKey> MATERIAL_BY_NAMESPACED_KEY = new HashMap<>();
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



    //register ice and packed ice and snow
    public static MaterialKey ICE = MaterialKey.from(266, 64, NamespacedKey.minecraft("ice"), MaterialCategory.ICE, Set.of(MaterialCategory.BLOCK, MaterialCategory.ICE));
    public static MaterialKey SNOW = MaterialKey.from(267, 64, NamespacedKey.minecraft("snow"), MaterialCategory.SNOW, Set.of(MaterialCategory.BLOCK, MaterialCategory.SNOW));




    static {
        Field[] declaredFields = Material.class.getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                Object o = field.get(null);
                if (o instanceof MaterialKey materialKey) {
                    LOGGER.debug("Register " + MATERIAL_BY_NAMESPACED_KEY.put(materialKey.getNamespacedKey(), materialKey));
                }
            }
        } catch (IllegalAccessException e) {
            LOGGER.error("", e);
        }

        LOGGER.info("Register {} materialKeys", MATERIAL_BY_NAMESPACED_KEY.size());
    }

    public static NamespacedKey getNamespacedKeyOfMaterialKey(int id, int data) {
        return NAMESPACED_BY_MATERIAL.get(key(id, data));
    }

    public static MaterialKey fromId(int id) {
        return MATERIAL_BY_ID.get(id);
    }

    public static MaterialKey fromNamespacedKey(NamespacedKey namespacedKey) {
        return MATERIAL_BY_NAMESPACED_KEY.get(namespacedKey);
    }

    public static Collection<MaterialKey> getRegisteredMaterials() {
        return MATERIAL_BY_ID.values();
    }

    public static Collection<NamespacedKey> getRegisteredNamespacedKeys() {
        return MATERIAL_BY_NAMESPACED_KEY.keySet();
    }

    public static void registerMaterialKey(MaterialKey materialKey) {
        MATERIAL_BY_NAMESPACED_KEY.put(materialKey.getNamespacedKey(), materialKey);
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

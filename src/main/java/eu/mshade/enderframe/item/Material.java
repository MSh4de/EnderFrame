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
    private final static Map<MaterialCategoryKey, Set<MaterialKey>> MATERIAL_KEYS_BY_CATEGORY = new HashMap<>();

    public static MaterialKey AIR = MaterialKey.from(0, NamespacedKey.minecraft("air"),  Set.of(MaterialCategory.BLOCK));
    public static MaterialKey STONE = MaterialKey.from(1, 64, NamespacedKey.minecraft("stone"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey GRANITE = MaterialKey.from(2, 64, NamespacedKey.minecraft("granite"),  Set.of(MaterialCategory.BLOCK));
    public static MaterialKey POLISHED_GRANITE = MaterialKey.from(3, 64, NamespacedKey.minecraft("polished_granite"),  Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DIORITE = MaterialKey.from(4, 64, NamespacedKey.minecraft("diorite"),  Set.of(MaterialCategory.BLOCK));
    public static MaterialKey POLISHED_DIORITE = MaterialKey.from(5, 64, NamespacedKey.minecraft("polished_diorite"),  Set.of(MaterialCategory.BLOCK));
    public static MaterialKey ANDESITE = MaterialKey.from(6, 64, NamespacedKey.minecraft("andesite"),  Set.of(MaterialCategory.BLOCK));
    public static MaterialKey POLISHED_ANDESITE = MaterialKey.from(7, 64, NamespacedKey.minecraft("polished_andesite"),  Set.of(MaterialCategory.BLOCK));
    public static MaterialKey GRASS = MaterialKey.from(8, 64, NamespacedKey.minecraft("grass"),  Set.of(MaterialCategory.BLOCK));
    public static MaterialKey DIRT = MaterialKey.from(9, 64, NamespacedKey.minecraft("dirt"),  Set.of(MaterialCategory.BLOCK));
    public static MaterialKey COARSE_DIRT = MaterialKey.from(10, 64,NamespacedKey.minecraft("coarse_dirt"),  Set.of(MaterialCategory.BLOCK));
    public static MaterialKey PODZOL = MaterialKey.from(11, 64, NamespacedKey.minecraft("podzol"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey COBBLESTONE = MaterialKey.from(12, 64,NamespacedKey.minecraft("cobblestone"), Set.of(MaterialCategory.BLOCK));
    public static MaterialKey OAK_WOOD_PLANKS = MaterialKey.from(13, 64, NamespacedKey.minecraft("oak_wood_planks"), Set.of(MaterialCategory.BLOCK));

    public static MaterialKey OAK_WOOD = MaterialKey.from(14, 64, NamespacedKey.minecraft("oak_wood"), Set.of(MaterialCategory.BLOCK));


    /**
     * Item tested with metadata
     */
    public static MaterialKey WOODEN_PICKAXE = MaterialKey.from(15, 1, NamespacedKey.minecraft("wooden_pickaxe"), Set.of(MaterialCategory.TOOLS));
    public static MaterialKey LEATHER_HELMET = MaterialKey.from(16, 1, NamespacedKey.minecraft("leather_helmet"), Set.of(MaterialCategory.ARMOR));
    public static MaterialKey PLAYER_HEAD = MaterialKey.from(17, 64, NamespacedKey.minecraft("player_head"), Set.of(MaterialCategory.BLOCK));


    static {
        Field[] declaredFields = Material.class.getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                Object o = field.get(null);
                if (o instanceof MaterialKey materialKey) {
                    LOGGER.debug("Register "+materialKey);
                    registerMaterialKey(materialKey);
                }
            }
        }catch (IllegalAccessException e){
            LOGGER.error("", e);
        }

        LOGGER.info("Register {} items", MATERIAL_BY_ID.size());
    }

    public static NamespacedKey getNamespacedKeyOfMaterialKey(int id, int data){
        return NAMESPACED_BY_MATERIAL.get(key(id, data));
    }

    public static MaterialKey fromId(int id){
        return MATERIAL_BY_ID.get(id);
    }

    public static Collection<MaterialKey> getRegisteredMaterials(){
        return MATERIAL_BY_ID.values();
    }

    public static void registerMaterialKey(MaterialKey materialKey) {
        MATERIAL_BY_ID.put(materialKey.getId(), materialKey);
        NAMESPACED_BY_MATERIAL.put(key(materialKey), materialKey.getNamespacedKey());
        for (MaterialCategoryKey materialCategoryKey : materialKey.getMaterialCategoryKeys()) {
            MATERIAL_KEYS_BY_CATEGORY.computeIfAbsent(materialCategoryKey, k -> new HashSet<>()).add(materialKey);
        }
    }

    private static String key(MaterialKey materialKey){
        return key(materialKey.getId(), materialKey.getMetadata());
    }

    private static String key(int id, int metadata){
        return id+":"+metadata;
    }

}

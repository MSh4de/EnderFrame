package eu.mshade.enderframe.item;

import eu.mshade.enderframe.mojang.NamespacedKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Material {


    private static Logger logger = LoggerFactory.getLogger(Material.class);

    private final static Map<String, NamespacedKey> namespacedKeyByMaterialKey = new HashMap<>();

    public static MaterialKey AIR = MaterialKey.from(0, NamespacedKey.minecraft("air"));
    public static MaterialKey STONE = MaterialKey.from(1, NamespacedKey.minecraft("stone"));
    public static MaterialKey GRANITE = MaterialKey.from(2, NamespacedKey.minecraft("granite"));
    public static MaterialKey POLISHED_GRANITE = MaterialKey.from(3, NamespacedKey.minecraft("polished_granite"));
    public static MaterialKey DIORITE = MaterialKey.from(4, NamespacedKey.minecraft("diorite"));
    public static MaterialKey POLISHED_DIORITE = MaterialKey.from(5, NamespacedKey.minecraft("polished_diorite"));
    public static MaterialKey ANDESITE = MaterialKey.from(6, NamespacedKey.minecraft("andesite"));
    public static MaterialKey POLISHED_ANDESITE = MaterialKey.from(7, NamespacedKey.minecraft("polished_andesite"));
    public static MaterialKey GRASS = MaterialKey.from(8, NamespacedKey.minecraft("grass"));
    public static MaterialKey DIRT = MaterialKey.from(9, NamespacedKey.minecraft("dirt"));
    public static MaterialKey COARSE_DIRT = MaterialKey.from(10, NamespacedKey.minecraft("coarse_dirt"));
    public static MaterialKey PODZOL = MaterialKey.from(11, NamespacedKey.minecraft("podzol"));

    /**
     * Item tested with metadata
     */
    public static MaterialKey WOODEN_PICKAXE = MaterialKey.from(12, NamespacedKey.minecraft("wooden_pickaxe"));
    public static MaterialKey LEATHER_HELMET = MaterialKey.from(13, NamespacedKey.minecraft("leather_helmet"));
    public static MaterialKey PLAYER_SKULL = MaterialKey.from(14, NamespacedKey.minecraft("player_skull"));

    static {
        Field[] declaredFields = Material.class.getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                Object o = field.get(null);
                if (o instanceof MaterialKey) {
                    MaterialKey materialKey = (MaterialKey) o;
                    namespacedKeyByMaterialKey.put(materialKey.getId() + ":" + materialKey.getMetadata(), materialKey.getNamespacedKey());
                }
            }
        }catch (IllegalAccessException e){
            logger.error("", e);
        }
    }

    public static NamespacedKey getNamespacedKeyOfMaterialKey(int id, int data){
        return namespacedKeyByMaterialKey.get(id+":"+data);
    }
    /*
    public static MaterialKey AIR = MaterialKey.from(0, 0);
    public static MaterialKey STONE = MaterialKey.from(1, 0);
    public static MaterialKey GRANITE = MaterialKey.from(1, 1);
    public static MaterialKey POLISHED_GRANITE = MaterialKey.from(1, 2);
    public static MaterialKey DIORITE = MaterialKey.from(1, 3);
    public static MaterialKey POLISHED_DIORITE = MaterialKey.from(1, 4);
    public static MaterialKey ANDESITE = MaterialKey.from(1, 5);
    public static MaterialKey POLISHED_ANDESITE = MaterialKey.from(1, 6);
    public static MaterialKey GRASS = MaterialKey.from(2, 0);
    public static MaterialKey DIRT = MaterialKey.from(3, 0);
    public static MaterialKey COARSE_DIRT = MaterialKey.from(3, 1);
    public static MaterialKey PODZOL = MaterialKey.from(3, 2);

     */


}

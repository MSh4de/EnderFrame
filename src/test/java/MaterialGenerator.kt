/*
import eu.mshade.enderframe.item.Material
import eu.mshade.enderframe.item.Material.*
import eu.mshade.enderframe.item.MaterialCategory
import eu.mshade.enderframe.item.MaterialCategoryKey
import org.bukkit.inventory.CreativeCategory
import java.io.File

val categories = mutableMapOf<String, MutableList<org.bukkit.Material>>()

fun main() {
//    val file = File("./Minecraft 1.19 Item List - Item List.csv")
    val output = File("./output.txt")
*/
/*    file.readLines().forEach {
        //YES,Stone,stone,64 Stackable,-,1,64,TRUE
        val split = it.split(",")
        val name = split[2]
        val stackSize = split[6]
        //output public static MaterialKey STONE = MaterialKey.from(NamespacedKey.minecraft("stone"), 64, MaterialCategory.BLOCK);
        //and set MaterialCategory by name
        output.appendText("public static MaterialKey ${name.uppercase()} = MaterialKey.from(NamespacedKey.minecraft(\"$name\"), $stackSize, MaterialCategory.BLOCK);\n")
    }*//*

    //count categories
*/
/*    org.bukkit.Material.values().forEach {
        if (it.isLegacy) return@forEach

        it.name.indexOf("_")
        val keywords = it.name.split("_")
        keywords.forEach { keyword ->
            if (categories.containsKey(keyword)) {
                categories[keyword]?.add(it)
            } else {
                categories[keyword] = mutableListOf(it)
            }
        }
    }
    categories.forEach { (t, u) ->
        println("$t: ${u.size}")
    }*//*

        org.bukkit.Material.values().forEach {
            if (it.isLegacy) return@forEach
            val maxDurability = it.maxDurability
            val name = it.name
            val maxStackSize = it.maxStackSize
            val category = it.name.split("_")[0]
            var extra: String? = null
*/
/*            if((countCategory[category] ?: 0) > 1) {
                extra = category
            }*//*

            val materialCategoryKeys = getMaterialCategory(it)
            val materialCategoryString = convertMaterialCategoryKeyToString(materialCategoryKeys, extra)

            output.appendText("public static MaterialKey ${name.uppercase()} = MaterialKey.from(NamespacedKey.minecraft(\"${name.lowercase()}\"), $maxStackSize, $maxDurability, $materialCategoryString);\n")
        }

}

fun convertMaterialCategoryKeyToString(materialCategoryKeys: Collection<MaterialCategoryKey>, extra: String?): String{
    val stringBuilder = StringBuilder()
    stringBuilder.append("Set.of(")
    materialCategoryKeys.forEachIndexed { index, it ->
        stringBuilder.append("MaterialCategory.")
        stringBuilder.append(it.name)
        if (index != materialCategoryKeys.size - 1) stringBuilder.append(", ")
    }
    if (extra != null) {
        stringBuilder.append(", ")
        stringBuilder.append("MaterialCategory.")
        stringBuilder.append(extra)
    }
    stringBuilder.append(")")


    return stringBuilder.toString()
}

fun getMaterialCategory(material: org.bukkit.Material): Collection<MaterialCategoryKey> {
    val materialCategories = mutableListOf<MaterialCategoryKey>()
    if (material.isBlock) {
        materialCategories.add(MaterialCategory.BLOCK)
    }
    if (material.isEdible) {
        materialCategories.add(MaterialCategory.FOOD)
    }
    if (material.isItem) {
        materialCategories.add(MaterialCategory.ITEM)
    }
    if (material.isRecord) {
        materialCategories.add(MaterialCategory.RECORD)
    }
    if (material.isFuel) {
        materialCategories.add(MaterialCategory.FUEL)
    }
    if (material.isFlammable) {
        materialCategories.add(MaterialCategory.FLAMMABLE)
    }
    if (material.isOccluding) {
        materialCategories.add(MaterialCategory.OCCLUDING)
    }
    if (material.isAir) {
        materialCategories.add(MaterialCategory.AIR)
    }
    if (material.isBurnable) {
        materialCategories.add(MaterialCategory.BURNABLE)
    }
    if (material.isInteractable) {
        materialCategories.add(MaterialCategory.INTERACTABLE)
    }
    if (material.isSolid) {
        materialCategories.add(MaterialCategory.SOLID)
    }

    if (material.hasGravity()) {
        materialCategories.add(MaterialCategory.GRAVITY)
    }

    if(material.maxDurability > 0){
        materialCategories.add(MaterialCategory.DURABILITY)
    }


    return materialCategories
}

*/

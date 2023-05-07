package eu.mshade.enderframe.item

import eu.mshade.enderframe.entity.Player

class ItemRuleRepository {

    private val itemRules = mutableMapOf<MaterialCategoryKey, ItemRule>()

    fun register(materialCategoryKey: MaterialCategoryKey, itemRule: ItemRule) {
        itemRules[materialCategoryKey] = itemRule
    }

    fun getItemRule(materialCategoryKey: MaterialCategoryKey): ItemRule? {
        return itemRules[materialCategoryKey]
    }
}

interface ItemRule {

    fun apply(player: Player, itemStack: ItemStack)

}
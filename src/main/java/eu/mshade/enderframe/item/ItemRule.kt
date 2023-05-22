package eu.mshade.enderframe.item

import eu.mshade.enderframe.entity.Player

class ItemRuleRepository {

    private val itemRules = mutableListOf<ItemRule>()

    fun register(itemRule: ItemRule){
        itemRules.add(itemRule)
    }

    fun getItemRule(material: MaterialKey): ItemRule? {
        var itemRule: ItemRule? = null
        for (rule in itemRules){
            if (rule.canApply(material)){
                if (itemRule != null){
                    throw IllegalStateException("Multiple item rule found for ${material.namespacedKey} (${itemRule.javaClass.name}, ${rule.javaClass.name})")
                }
                itemRule = rule
            }
        }

        return itemRule
    }
}

interface ItemRule {

    fun apply(player: Player, itemStack: ItemStack)

    fun canApply(material: MaterialKey): Boolean

}
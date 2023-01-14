package eu.mshade.enderframe.entity

open class EntityMapper {

    private val categoryByEntityKey =  mutableMapOf<EntityKey, EntityCategory>()

    fun register(EntityKey: EntityKey, entityCategory: EntityCategory) {
        this.categoryByEntityKey[EntityKey] = entityCategory
    }

    fun getCategory(EntityKey: EntityKey): EntityCategory? {
        return categoryByEntityKey[EntityKey]
    }
}
package eu.mshade.enderframe.entity

open class EntityMapper {

    private val categoryByEntityKey =  mutableMapOf<EntityKey, EntityCategory>()

    fun register(entityKey: EntityKey, entityCategory: EntityCategory) {
        this.categoryByEntityKey[entityKey] = entityCategory
    }

    fun getCategory(entityKey: EntityKey): EntityCategory? {
        return categoryByEntityKey[entityKey]
    }
}
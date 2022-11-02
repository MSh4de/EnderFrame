package eu.mshade.enderframe.entity

import java.util.*

open class EntityMapper {

    private val categoryByEntityType: MutableMap<EntityType, EntityCategory> = EnumMap(EntityType::class.java)

    fun register(entityType: EntityType, entityCategory: EntityCategory) {
        this.categoryByEntityType[entityType] = entityCategory
    }

    fun getCategory(entityType: EntityType): EntityCategory? {
        return categoryByEntityType[entityType]
    }
}
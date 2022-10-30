package eu.mshade.enderchest.entity

import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.entity.metadata.*
import java.util.UUID

class AgeEntityMetadataAdapter(val entity: Entity) {

    fun setAge(age: Int) {
        entity.metadataKeyValueBucket.setMetadataKeyValue(AgeEntityMetadata(age))
    }

    fun getAge(): Int {
        return entity.metadataKeyValueBucket.getMetadataKeyValue(EntityMetadataKey.AGE, AgeEntityMetadata::class.java).metadataValue
    }

    fun setAgeLock(ageLocked: Boolean) {
        entity.metadataKeyValueBucket.setMetadataKeyValue(AgeLockedEntityMetadata(ageLocked))
    }

    fun isAgeLock(): Boolean {
        return entity.metadataKeyValueBucket.getMetadataKeyValueOrDefault(EntityMetadataKey.AGE_LOCKED, AgeLockedEntityMetadata(false)).metadataValue
    }
}

class BreedableEntityMetadataAdapter(val entity: Entity) {

    fun setBreedable(breedable: Boolean) {
        entity.metadataKeyValueBucket.setMetadataKeyValue(BreedableEntityMetadata(breedable))
    }

    fun isBreedable(): Boolean {
        return entity.metadataKeyValueBucket.getMetadataKeyValueOrDefault(EntityMetadataKey.BREEDABLE, BreedableEntityMetadata(true)).metadataValue
    }
}

class TameableEntityMetadataAdapter(val entity: Entity) {

    fun setTamed(tamed: Boolean) {
        entity.metadataKeyValueBucket.setMetadataKeyValue(BreedableEntityMetadata(tamed))
    }

    fun isTamed(): Boolean {
        return entity.metadataKeyValueBucket.getMetadataKeyValueOrDefault(EntityMetadataKey.IS_TAMED, BreedableEntityMetadata(true)).metadataValue
    }

    fun setSitting(sitting: Boolean) {
        entity.metadataKeyValueBucket.setMetadataKeyValue(BreedableEntityMetadata(sitting))
    }

    fun isSit(): Boolean {
        return entity.metadataKeyValueBucket.getMetadataKeyValueOrDefault(EntityMetadataKey.IS_SITTING, BreedableEntityMetadata(true)).metadataValue
    }

    fun getOwner(): UUID {
        return entity.metadataKeyValueBucket.getMetadataKeyValueOrDefault(EntityMetadataKey.OWNER, OwnerEntityMetadata(null)).metadataValue
    }
}

class RideableEntityMetadataAdapter(val entity: Entity) {

    fun setSaddle(saddled: Boolean) {
        entity.metadataKeyValueBucket.setMetadataKeyValue(SaddleEntityMetadata(saddled))
    }

    fun isSaddle(): Boolean {
        return entity.metadataKeyValueBucket.getMetadataKeyValueOrDefault(EntityMetadataKey.SADDLE, SaddleEntityMetadata(false)).metadataValue
    }
}
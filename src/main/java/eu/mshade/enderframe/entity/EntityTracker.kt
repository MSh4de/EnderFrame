package eu.mshade.enderframe.entity

import eu.mshade.enderframe.EnderFrame
import eu.mshade.enderframe.event.EquipmentChangeEvent
import eu.mshade.enderframe.inventory.EquipmentSlot
import eu.mshade.enderframe.item.ItemStack
import eu.mshade.enderframe.tick.Tickable
import eu.mshade.enderframe.world.chunk.Chunk
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue

object EntityTracker : Tickable() {

    val entities = ConcurrentLinkedQueue<Entity>()
    val trackedEntities = ConcurrentHashMap<Entity, EntityTrackerEntry>()

    override fun tick() {
        for (entity in entities) {
            if (entity is Player) {

                val location = entity.getLocation()
                val world = location.world

                val chunkX: Int = location.chunkX
                val chunkZ: Int = location.chunkZ
                val entities: MutableSet<Entity> = HashSet()

                for (x in chunkX - 5..chunkX + 5) {
                    for (z in chunkZ - 5..chunkZ + 5) {
                        if ((chunkX - x) * (chunkX - x) + (chunkZ - z) * (chunkZ - z) <= 5 * 5) {
                            val chunk: Chunk = world.getChunk(x, z).join()
                            entities.addAll(chunk.entities)

                            for (watcher in chunk.watchers) {
                                if (watcher is Player && watcher != entity) {
                                    entities.add(watcher)
                                }
                            }

                        }
                    }
                }

                //distance 80 that mean 5 chunk of distance view
                val entitiesFiltered = getEntities(entities, entity, 80)

                for (target in entitiesFiltered) {
                    target.addWatcher(entity)
                }

                for (target in entity.getLookAtEntity()) {
                    if (!entitiesFiltered.contains(target)) {
                        target.removeWatcher(entity)
                    }
                }


                for (watchedEntity in entity.getLookAtEntity()) {
                    if (watchedEntity.getTickLocation() != watchedEntity.getTickBeforeLocation()) {
                        entity.minecraftSession.sendUpdateLocation(
                            watchedEntity,
                            watchedEntity.getTickBeforeLocation(),
                            watchedEntity.getTickLocation()
                        )
                    }

                    val consumeUpdatedMetadataKeyValue = watchedEntity.metadata.consumeUpdatedMetadataKeyValue()
                    if (consumeUpdatedMetadataKeyValue.isNotEmpty()) {
                        entity.minecraftSession.sendMetadata(watchedEntity, consumeUpdatedMetadataKeyValue)
                    }

                    val trackerEntry = trackedEntities[watchedEntity]!!
                    trackerEntry.update(entity)
                }
            }
        }
    }

    fun track(entity: Entity) {
        entities.add(entity)
        trackedEntities[entity] = EntityTrackerEntry(entity)
    }

    fun unTrack(entity: Entity) {
        entities.remove(entity)
        trackedEntities.remove(entity)
    }

    private fun getEntities(entities: Collection<Entity>, source: Entity, distance: Int): Collection<Entity> {
        val newEntities = HashSet<Entity>()
        for (entity in entities) {
            if (entity.getLocation().distanceXZ(source.getLocation()) <= distance) {
                newEntities.add(entity)
            }
        }
        return newEntities
    }
}

class EntityTrackerEntry(val entity: Entity){

    private var lastEquipment = mutableMapOf<EquipmentSlot, ItemStack>()

    fun update(player: Player){
        if (entity is Equipable) {
            val equipments = entity.getEquipments()
            if (lastEquipment == equipments) return

            for (value in EquipmentSlot.values()) {
                val itemStack = equipments[value]
                val lastItemStack = lastEquipment[value]
                if (itemStack != lastItemStack) {
                    val equipmentChangeEvent = EquipmentChangeEvent(entity, value, lastItemStack, itemStack)
                    EnderFrame.get().minecraftEvents.publish(equipmentChangeEvent)
                    if (equipmentChangeEvent.isCancelled) continue
                    player.minecraftSession.sendEquipment(entity, value, itemStack)
                    if (itemStack == null){
                        lastEquipment.remove(value)
                    }else {
                        lastEquipment[value] = itemStack
                    }
                }
            }


        }
    }

}
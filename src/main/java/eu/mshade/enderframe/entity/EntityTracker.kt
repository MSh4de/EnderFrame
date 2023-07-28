package eu.mshade.enderframe.entity

import eu.mshade.enderframe.EnderFrame
import eu.mshade.enderframe.MinecraftServer
import eu.mshade.enderframe.event.EquipmentChangeEvent
import eu.mshade.enderframe.inventory.EquipmentSlot
import eu.mshade.enderframe.item.ItemStack
import eu.mshade.enderframe.tick.Tickable
import eu.mshade.enderframe.world.chunk.Chunk
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.Semaphore

object EntityTracker : Tickable() {

    private val entities = ConcurrentLinkedQueue<Entity>()
    private val trackedEntities = ConcurrentHashMap<Entity, EntityTrackerEntry>()


    const val CHUNK_VIEW_DISTANCE = 5
    const val ENTITY_VIEW_DISTANCE = 80


    override fun tick() {
        entities.forEach{ entity ->
            if (entity is Player) {
                val location = entity.getLocation()
                val world = location.world

                val chunkX: Int = location.chunkX
                val chunkZ: Int = location.chunkZ
                val entitiesInRange: MutableList<Entity> = ArrayList()
                val chunks = mutableListOf<CompletableFuture<Chunk>?>()

                for (x in chunkX - CHUNK_VIEW_DISTANCE..chunkX + CHUNK_VIEW_DISTANCE) {
                    for (z in chunkZ - CHUNK_VIEW_DISTANCE..chunkZ + CHUNK_VIEW_DISTANCE) {
                        if ((chunkX - x) * (chunkX - x) + (chunkZ - z) * (chunkZ - z) <= CHUNK_VIEW_DISTANCE * CHUNK_VIEW_DISTANCE) {
                            /*if (entity.hasLookAtChunk(x, z)) */
                            chunks.add(world.getChunk(x, z))
                        }
                    }
                }

                chunks.forEach { cfChunk ->
                    cfChunk?.join()?.let { chunk ->
                        entitiesInRange.addAll(chunk.entities)

                        chunk.watchers.filterIsInstance<Player>()
                            .filter { it != entity }
                            .forEach { entitiesInRange.add(it) }
                    }
                }

                val entitiesFiltered = getEntitiesInRange(entitiesInRange, entity, ENTITY_VIEW_DISTANCE)

                entitiesFiltered.forEach { target ->
                    target.addWatcher(entity)
                }

                entity.getLookAtEntity().filterNot { entitiesFiltered.contains(it) }
                    .forEach { target ->
                        target.removeWatcher(entity)
                    }

                entity.getLookAtEntity().forEach { watchedEntity ->
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

                    trackedEntities[watchedEntity]?.update(entity)
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

    private fun getEntitiesInRange(entities: Collection<Entity>, source: Entity, distance: Int): Collection<Entity> {
        val newEntities = ArrayList<Entity>()
        entities.forEach { entity ->
            if (entity.getLocation().distanceXZ(source.getLocation()) <= distance) {
                newEntities.add(entity)
            }
        }
        return newEntities
    }
}

class EntityTrackerEntry(private val entity: Entity) {

    private var lastEquipment = mutableMapOf<EquipmentSlot, ItemStack>()

    fun update(player: Player) {
        if (entity is Equipable) {
            val equipments = entity.getEquipments()
            if (lastEquipment == equipments) return

            EquipmentSlot.values().forEach { value ->
                val itemStack = equipments[value]
                val lastItemStack = lastEquipment[value]
                if (itemStack != lastItemStack) {
                    val equipmentChangeEvent = EquipmentChangeEvent(entity, value, lastItemStack, itemStack)
                    MinecraftServer.getMinecraftEvent().publish(equipmentChangeEvent)
                    if (equipmentChangeEvent.isCancelled) return@forEach
                    player.minecraftSession.sendEquipment(entity, value, itemStack)
                    if (itemStack == null) {
                        lastEquipment.remove(value)
                    } else {
                        lastEquipment[value] = itemStack
                    }
                }
            }
        }
    }
}

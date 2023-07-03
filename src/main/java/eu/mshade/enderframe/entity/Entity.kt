package eu.mshade.enderframe.entity

import eu.mshade.enderframe.UniqueId
import eu.mshade.enderframe.attribute.AttributeKey
import eu.mshade.enderframe.attribute.AttributeProperty
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket
import eu.mshade.enderframe.tick.Tickable
import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue

abstract class Entity(
    private var location: Location,
    private var velocity: Vector,
    private val entityId: Int,
    val uniqueId: UUID,
    var entityKey: EntityKey
) : Tickable() {

    companion object {
        val ID = UniqueId()
    }

    private var beforeLocation: Location
    private var tickBeforeLocation: Location
    private var tickLocation: Location
    val metadata = MetadataKeyValueBucket(true)
    private val properties = mutableMapOf<AttributeKey, AttributeProperty>()

    protected val viewers = ConcurrentLinkedQueue<Entity>()

    init {
        beforeLocation = location.clone()
        tickBeforeLocation = location.clone()
        tickLocation = location.clone()
    }

    constructor(location: Location, entityId: Int, entityKey: EntityKey) : this(
        location,
        Vector(),
        entityId,
        UUID.randomUUID(),
        entityKey
    )

    override fun tick() {

    }

    fun getLocation(): Location {
        return location
    }

    fun setLocation(location: Location) {
        beforeLocation = this.location.clone()
        this.location = location
    }

    fun getBeforeLocation(): Location {
        return beforeLocation
    }

    fun getTickLocation(): Location {
        return tickLocation
    }

    fun setTickLocation(location: Location) {
        tickBeforeLocation = tickLocation.clone()
        tickLocation = location
    }

    fun getTickBeforeLocation(): Location {
        return tickBeforeLocation
    }

    fun getEntityId(): Int {
        return entityId
    }

    fun getVelocity(): Vector {
        return velocity
    }

    fun addWatcher(entity: Entity?) {
        if (entity == this) return
        if (this.isWatching(entity)) return
        this.viewers.add(entity)
        if (entity is Player){
            entity.addLookAtEntity(this)
            entity.minecraftSession.sendEntity(this)
        }
    }

    fun removeWatcher(entity: Entity?) {
        if (entity == this) return
        if (!this.isWatching(entity)) return
        this.viewers.remove(entity)
        if (entity is Player){
            entity.removeLookAtEntity(this)
            entity.minecraftSession.removeEntity(this)
        }
    }

    fun isWatching(entity: Entity?): Boolean {
        return this.viewers.contains(entity)
    }

    fun getWatchers(): MutableCollection<Entity> {
        return this.viewers
    }

    fun getProperties(): List<AttributeProperty> {
        return properties.values.toList()
    }

    fun getProperty(key: AttributeKey): AttributeProperty? {
        return properties[key]
    }

    fun addProperty(property: AttributeProperty) {
        properties[property.attribute] = property
    }
}

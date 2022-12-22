package eu.mshade.enderframe.entity

import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import java.util.*

abstract class ArmorStand(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : LivingEntity(location, velocity, entityId, uuid, EntityType.ARMOR_STAND) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Arrow : Entity, Projectile {
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.ARROW
    )

    constructor(location: Location, entityId: Int) : super(
        location,
        Vector(),
        entityId,
        UUID.randomUUID(),
        EntityType.ARROW
    )
}

abstract class Boat(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : Entity(location, velocity, entityId, uuid, EntityType.BOAT), Damageable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class EnderCrystal(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : Entity(location, velocity, entityId, uuid, EntityType.ENDER_CRYSTAL) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Firework : Entity {
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.FIREWORK
    )

    constructor(location: Location, entityId: Int) : super(
        location,
        Vector(),
        entityId,
        UUID.randomUUID(),
        EntityType.FIREWORK
    )
}

abstract class FurnaceMinecart : Minecart {
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.MINECART_FURNACE
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.MINECART_FURNACE)
}

abstract class Item : Entity {
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.DROPPED_ITEM
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.DROPPED_ITEM)
}

abstract class ItemFrame : Entity, Hanging {
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.ITEM_FRAME
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.ITEM_FRAME)
}

abstract class Minecart(location: Location, velocity: Vector, entityId: Int, uuid: UUID, entityKey: EntityKey) : Entity(location, velocity, entityId, uuid, entityKey), Damageable {

    constructor(location: Location, entityId: Int, entityKey: EntityKey) : this(
        location,
        Vector(),
        entityId,
        UUID.randomUUID(),
        entityKey
    )
}
package eu.mshade.enderframe.entity

import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import java.util.*

abstract class EnderDragon(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : LivingEntity(location, velocity, entityId, uuid, EntityType.ENDER_DRAGON) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Wither : LivingEntity {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.WITHER
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.WITHER)
}

abstract class GiantZombie : LivingEntity {
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.GIANT
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.GIANT)
}
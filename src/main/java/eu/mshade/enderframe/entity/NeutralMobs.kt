package eu.mshade.enderframe.entity

import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import java.util.*

abstract class Bee(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.BEE) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class CaveSpider(location: Location, velocity: Vector, entityId: Int, uuid: UUID): Spider(location, velocity, entityId, uuid, EntityType.CAVE_SPIDER) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) {}
}

abstract class Dolphin(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.DOLPHIN) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Enderman(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : LivingEntity(location, velocity, entityId, uuid, EntityType.ENDERMAN) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Goat(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.GOAT) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class IronGolem : LivingEntity {
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.IRON_GOLEM
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.IRON_GOLEM)
}

abstract class Llama(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.LLAMA) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class PiglinAdult(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.ADULT_PIGLIN) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Panda(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.PANDA) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class PolarBearAdult(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.POLAR_BEAR) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Spider : LivingEntity {

    protected constructor(
        location: Location,
        velocity: Vector,
        entityId: Int,
        uuid: UUID,
        EntityKey: EntityKey
    ): super(location, velocity, entityId, uuid, EntityKey)

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.SPIDER
    )

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) {}
}

abstract class Wolf(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.WOLF) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class ZombifiedPiglin : LivingEntity, Ageable {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.ZOMBIFIED_PIGLIN
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.ZOMBIFIED_PIGLIN)
}
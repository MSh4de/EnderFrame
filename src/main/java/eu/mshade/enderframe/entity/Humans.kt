package eu.mshade.enderframe.entity

import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import java.util.*

abstract class NonPlayerCharacter : Player {

    /*
    TODO: Changer l'implementation
     */

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.NON_PLAYER_CHARACTER
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.NON_PLAYER_CHARACTER)
}

abstract class Villager : LivingEntity {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.VILLAGER
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.VILLAGER) {}
}
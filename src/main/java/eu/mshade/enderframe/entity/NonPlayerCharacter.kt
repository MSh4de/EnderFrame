package eu.mshade.enderframe.entity

import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import java.util.*

abstract class NonPlayerCharacter : Player {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.NO_PLAYER_CHARACTER
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.NO_PLAYER_CHARACTER)
}
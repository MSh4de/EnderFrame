package eu.mshade.enderframe.entity

import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import java.util.*

abstract class LivingEntity : Entity {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID, entityKey: EntityKey) : super(
        location,
        velocity,
        entityId,
        uuid,
        entityKey
    )

    constructor(location: Location, entityId: Int, entityKey: EntityKey) : super(location, entityId, entityKey)
}
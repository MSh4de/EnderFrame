package eu.mshade.enderframe.entity

import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import java.util.*

/*
Ref: https://www.rockpapershotgun.com/minecraft-mobs-list-hostile-netural-passive-tameable-new-mobs#:~:text=Minecraft%20has%20come%20a%20long,very%20differently%20from%20the%20rest.
 */

abstract class Blaze : LivingEntity {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.BLAZE
    )

    constructor(location: Location, entityId: Int) : super(
        location,
        Vector(),
        entityId,
        UUID.randomUUID(),
        EntityType.BLAZE
    )
}

//Chicken Jockey

abstract class Creeper(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.CREEPER) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Drowned(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.DROWNED) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class ElderGuardian(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.ELDER_GUARDIAN) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Endermite(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.ENDERMITE) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Evoker(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.EVOKER) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Ghast : LivingEntity {
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.GHAST
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.GHAST)
}

abstract class Guardian : LivingEntity {
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.GUARDIAN
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.GUARDIAN) {}
}

abstract class Hoglin(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.HOGLIN) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Husk(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.HUSK) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class MagmaCube : LivingEntity {
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.MAGMA_CUBE
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.MAGMA_CUBE)
}

abstract class Phantom(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.PHANTOM) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class PiglinBrute(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.PIGLIN_BRUTE) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Pillager(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.PILLAGER) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Ravager(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.RAVAGER) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class RavagerJockey(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.RAVAGER) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Shulker(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.SHULKER) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Silverfish : LivingEntity {
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.SILVERFISH
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.SILVERFISH)
}

abstract class Skeleton : LivingEntity {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.SKELETON
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.SKELETON) {}
}

abstract class SkeletonHorseman(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.SKELETON_HORSE) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Slime : LivingEntity {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID, entityKey: EntityKey) : super(
        location,
        velocity,
        entityId,
        uuid,
        entityKey
    )

    constructor(location: Location, entityId: Int, entityKey: EntityKey) : super(location, entityId, entityKey)

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.SLIME
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.SLIME) {}
}

abstract class SpiderJockey(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.SPIDER_JOCKEY) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Stray(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.STRAY) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Vex(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.VEX) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Vindicator(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.VINDICATOR) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Witch : LivingEntity {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.WITCH
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.WITCH) {}
}

abstract class WitherSkeleton(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.WITHER_SKELETON) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Zoglin(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.ZOGLIN) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Zombie : LivingEntity, Ageable {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID, EntityKey: EntityKey) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityKey
    )

    constructor(location: Location, entityId: Int, EntityKey: EntityKey) : super(location, entityId, EntityKey) {}
    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.ZOMBIE
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.ZOMBIE) {}
}

abstract class ZombieVillager(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.ZOMBIE_VILLAGER) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Warden(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.WARDEN) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

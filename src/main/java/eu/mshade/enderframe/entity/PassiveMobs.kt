package eu.mshade.enderframe.entity

import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import java.util.*

abstract class Allay(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.ALLAY) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Axolotl(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.AXOLOTL) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Bat(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.BAT) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Cat(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.CAT) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Chicken(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.CHICKEN), Ageable, Breedable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Cod(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.COD) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Cow(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.COW), Ageable, Breedable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) 
}

abstract class Donkey(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.DONKEY), Ageable, Rideable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) 
}

abstract class Fox(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.FOX) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Frog(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.FROG) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class GlowSquid(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.GLOW_SQUID) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Horse(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.HORSE), Ageable, Rideable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) 
}

abstract class Mooshroom(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.MUSHROOM_COW), Ageable, Breedable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) 
}

abstract class Mule(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.MULE), Ageable, Rideable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) 
}

abstract class Ocelot(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.OCELOT), Ageable, Breedable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Parrot(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.PARROT) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Pig(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.PIG), Ageable, Breedable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) 
}

//Todo change his type
abstract class BabyPiglin(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.BABY_PIGLIN) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

//Him too
abstract class BabyPolarBear(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.POLAR_BEAR), Ageable, Breedable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) 
}

abstract class PufferFish(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.PUFFERFISH) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Rabbit(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.RABBIT), Ageable, Breedable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) 
}

abstract class Salmon(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.SALMON) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Sheep(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.SHEEP), Ageable, Breedable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) 
}

abstract class SkeletonHorse(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.SKELETON_HORSE), Ageable, Rideable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) 
}

abstract class Snowman : LivingEntity {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.SNOWMAN
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.SNOWMAN)
}

abstract class Squid : LivingEntity {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.SQUID
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.SQUID)
}

abstract class Strider(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.STRIDER) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Tadpole(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.TADPOLE) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class TropicalFish(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.TROPICAL_FISH) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}

abstract class Turtle(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.TURTLE), Ageable, Rideable {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID()) 
}

abstract class Villager : LivingEntity {

    constructor(location: Location, velocity: Vector, entityId: Int, uuid: UUID) : super(
        location,
        velocity,
        entityId,
        uuid,
        EntityType.VILLAGER
    )

    constructor(location: Location, entityId: Int) : super(location, entityId, EntityType.VILLAGER)
}

abstract class WanderingTrader(location: Location, velocity: Vector, entityId: Int, uuid: UUID): LivingEntity(location, velocity, entityId, uuid, EntityType.WANDERING_TRADER) {

    constructor(location: Location, entityId: Int) : this(location, Vector(), entityId, UUID.randomUUID())
}
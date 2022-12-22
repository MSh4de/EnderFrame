package eu.mshade.enderframe.entity.metadata

import eu.mshade.enderframe.metadata.MetadataKey

object EntityMetadataKey {

    //Basic
    val VARIANT: MetadataKey = MetadataKey.from("ENTITY_VARIANT")
    val FLYING: MetadataKey = MetadataKey.from("ENTITY_FLYING")
    val OWNER: MetadataKey = MetadataKey.from("ENTITY_OWNER")
    val SADDLE: MetadataKey = MetadataKey.from("ENTITY_SADDLE")
    val IS_POWERED: MetadataKey = MetadataKey.from("ENTITY_IS_POWERED")


    //Entity
    val ON_FIRE: MetadataKey = MetadataKey.from("ENTITY_ON_FIRE")
    val CROUCHED: MetadataKey = MetadataKey.from("ENTITY_CROUCHED")
    val SPRINTING: MetadataKey = MetadataKey.from("ENTITY_SPRINTING")
    val EATING: MetadataKey = MetadataKey.from("ENTITY_EATING")
    val HANDLING: MetadataKey = MetadataKey.from("ENTITY_HANDLING")
    val INVISIBLE: MetadataKey = MetadataKey.from("ENTITY_INVISIBLE")
    val AIR_TICKS: MetadataKey = MetadataKey.from("ENTITY_AIR_TICKS")

    //LivingEntity
    val CUSTOM_NAME: MetadataKey = MetadataKey.from("ENTITY_CUSTOM_NAME")
    val CUSTOM_NAME_VISIBLE: MetadataKey = MetadataKey.from("ENTITY_CUSTOM_NAME_VISIBLE")
    val HEALTH: MetadataKey = MetadataKey.from("ENTITY_HEALTH")
    val POTION_EFFECT_COLOR: MetadataKey = MetadataKey.from("ENTITY_POTION_EFFECT_COLOR")
    val POTION_EFFECT_AMBIENT: MetadataKey = MetadataKey.from("ENTITY_POTION_EFFECT_AMBIENT")
    val NUMBER_OF_ARROWS_IN_ENTITY: MetadataKey = MetadataKey.from("ENTITY_NUMBER_OF_ARROWS_IN_ENTITY")
    val WHETHER_ARTIFICIAL_INTELLIGENCE: MetadataKey = MetadataKey.from("ENTITY_WHETHER_ARTIFICIAL_INTELLIGENCE")


    //Human
    val SKIN_PART: MetadataKey = MetadataKey.from("ENTITY_SKIN_PART")
    val HIDE_CAPE: MetadataKey = MetadataKey.from("ENTITY_HIDE_CAPE")
    val ADDITIONAL_HEARTS: MetadataKey = MetadataKey.from("ENTITY_ADDITIONAL_HEARTS")
    val SCORE: MetadataKey = MetadataKey.from("ENTITY_SCORE")


    //Behaviours

    //Ageable
    val AGE: MetadataKey = MetadataKey.from("ENTITY_AGE")
    val CHILD: MetadataKey = MetadataKey.from("ENTITY_CHILD")

    //Tameable
    val TAMED: MetadataKey = MetadataKey.from("ENTITY_TAMED")
    val SITTING: MetadataKey = MetadataKey.from("ENTITY_SITTING")


    //Objects

    //ArmorStand
    val SMALL_ARMOR_STAND: MetadataKey = MetadataKey.from("ENTITY_SMALL_ARMOR_STAND")
    val GRAVITY: MetadataKey = MetadataKey.from("ENTITY_GRAVITY")
    val ARMS: MetadataKey = MetadataKey.from("ENTITY_ARMS")
    val REMOVE_BASE_PLATE: MetadataKey = MetadataKey.from("ENTITY_REMOVE_BASE_PLATE")
    val MARKER: MetadataKey = MetadataKey.from("ENTITY_MARKER")
    val HEAD_ROTATION: MetadataKey = MetadataKey.from("ENTITY_HEAD_ROTATION")
    val BODY_ROTATION: MetadataKey = MetadataKey.from("ENTITY_BODY_ROTATION")
    val LEFT_ARM_ROTATION: MetadataKey = MetadataKey.from("ENTITY_LEFT_ARM_ROTATION")
    val RIGHT_ARM_ROTATION: MetadataKey = MetadataKey.from("ENTITY_RIGHT_ARM_ROTATION")
    val LEFT_LEG_ROTATION: MetadataKey = MetadataKey.from("ENTITY_LEFT_LEG_ROTATION")
    val RIGHT_LEG_ROTATION: MetadataKey = MetadataKey.from("ENTITY_RIGHT_LEG_ROTATION")

    //Falling Block
    val ITEM: MetadataKey = MetadataKey.from("ENTITY_ITEM")

    //Arrow
    val CRITICAL: MetadataKey = MetadataKey.from("ENTITY_CRITICAL")

    //Boat
    val TIME_SINCE_LAST_HIT: MetadataKey = MetadataKey.from("ENTITY_TIME_SINCE_LAST_HIT")
    val FORWARD_DIRECTION: MetadataKey = MetadataKey.from("ENTITY_FORWARD_DIRECTION")
    val DAMAGE_TAKEN: MetadataKey = MetadataKey.from("ENTITY_DAMAGE_TAKEN")


    //Hostile

    //Zombie
    val IS_VILLAGER: MetadataKey = MetadataKey.from("ENTITY_IS_VILLAGER")
    val IS_CONVERTING: MetadataKey = MetadataKey.from("ENTITY_IS_CONVERTING")

    //Ghast
    val IS_ATTACKING: MetadataKey = MetadataKey.from("ENTITY_IS_ATTACKING")

    //Guardian
    val TARGET_ENTITY_ID: MetadataKey = MetadataKey.from("ENTITY_TARGET_ID")
    val IS_ELDERLY: MetadataKey = MetadataKey.from("ENTITY_IS_ELDERLY")
    val IS_RETRACTING_SPIKES: MetadataKey = MetadataKey.from("ENTITY_IS_RETRACTING_SPIKES")

    //Slime
    val SIZE: MetadataKey = MetadataKey.from("ENTITY_SIZE")

    //Witch
    val IS_AGGRESSIVE: MetadataKey = MetadataKey.from("ENTITY_IS_AGGRESSIVE")

    //Creeper
    val CREEPER_STATE: MetadataKey = MetadataKey.from("ENTITY_CREEPER_STATE")


    //Neutral

    //Spider
    val CLIMBING: MetadataKey = MetadataKey.from("ENTITY_CLIMBING")

    //IronGolem
    val IS_PLAYER_CREATED: MetadataKey = MetadataKey.from("ENTITY_IS_PLAYER_CREATED")

    //Wolf
    val IS_ANGRY: MetadataKey = MetadataKey.from("ENTITY_IS_ANGRY")
    val BEGGING: MetadataKey = MetadataKey.from("ENTITY_BEGGING")
    val COLLAR_COLOR: MetadataKey = MetadataKey.from("ENTITY_COLLAR_COLOR")

    //Enderman
    val SCREAMING: MetadataKey = MetadataKey.from("ENTITY_SCREAMING")


    //Passive

    //Bat
    val IS_HANGING: MetadataKey = MetadataKey.from("ENTITY_IS_HANGING")

    //Sheep
    val IS_SHEARED: MetadataKey = MetadataKey.from("ENTITY_IS_SHEARED")
    val COLOR: MetadataKey = MetadataKey.from("ENTITY_COLOR")

    //Horse

    val STYLE: MetadataKey = MetadataKey.from("ENTITY_STYLE")
    val HAS_CHEST: MetadataKey = MetadataKey.from("ENTITY_HAS_CHEST")
    val IS_BRED: MetadataKey = MetadataKey.from("ENTITY_IS_BRED")
    val IS_REARING: MetadataKey = MetadataKey.from("ENTITY_IS_REARING")
    val MOUTH_OPEN: MetadataKey = MetadataKey.from("ENTITY_MOUTH_OPEN")
    val HORSE_COLOR: MetadataKey = MetadataKey.from("ENTITY_HORSE_COLOR")
    val ARMOR: MetadataKey = MetadataKey.from("ENTITY_ARMOR")

    //Boss

    //Wither
    val INVULNERABLE_TIME: MetadataKey = MetadataKey.from("ENTITY_INVULNERABLE_TIME")
}
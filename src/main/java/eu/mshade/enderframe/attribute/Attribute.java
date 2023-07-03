package eu.mshade.enderframe.attribute;

public class Attribute {

    public static AttributeKey MAX_HEALTH = AttributeKey.from("MAX_HEALTH", 20, 1,1024);
    public static AttributeKey FOLLOW_RANGE = AttributeKey.from("FOLLOW_RANGE", 32, 2048);
    public static AttributeKey KNOCKBACK_RESISTANCE = AttributeKey.from("KNOCKBACK_RESISTANCE", 0, 1);
    public static AttributeKey MOVEMENT_SPEED = AttributeKey.from("MOVEMENT_SPEED", 0.7, 1024);
    public static AttributeKey FLYING_SPEED = AttributeKey.from("FLYING_SPEED", 0.4, 1024);
    public static AttributeKey ATTACK_DAMAGE = AttributeKey.from("ATTACK_DAMAGE", 2, 2048);
    public static AttributeKey ATTACK_KNOCKBACK = AttributeKey.from("ATTACK_KNOCKBACK", 0, 5);
    public static AttributeKey ATTACK_SPEED = AttributeKey.from("ATTACK_SPEED", 4, 1024);
    public static AttributeKey ARMOR = AttributeKey.from("ARMOR", 0, 30);
    public static AttributeKey ARMOR_TOUGHNESS = AttributeKey.from("ARMOR_TOUGHNESS", 0, 20);
    public static AttributeKey LUCK = AttributeKey.from("LUCK", 0, -1024, 1024);
    public static AttributeKey ZOMBIE_SPAWN_REINFORCEMENTS = AttributeKey.from("ZOMBIE_SPAWN_REINFORCEMENTS", 0,  1);
    public static AttributeKey HORSE_JUMP_STRENGTH = AttributeKey.from("HORSE_JUMP_STRENGTH", 0.7, 0, 2);
    public static AttributeKey REACH_DISTANCE = AttributeKey.from("REACH_DISTANCE", 5, 1024);
    public static AttributeKey SWIM_SPEED = AttributeKey.from("SWIM_SPEED", 1, 1024);
}

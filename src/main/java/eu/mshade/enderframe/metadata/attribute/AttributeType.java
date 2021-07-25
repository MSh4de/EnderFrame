package eu.mshade.enderframe.metadata.attribute;

public enum AttributeType {
    MAX_HEALTH("generic.maxHealth", 20, Double.MAX_VALUE),
    FOLLOW_RANGE("generic.followRange", 32, 2048),
    KNOCKBACK_RESISTANCE("generic.knockbackResistance", 0, 1),
    MOVEMENT_SPEED("generic.movementSpeed", 0.699999988079071, Double.MAX_VALUE),
    ATTACK_DAMAGE("generic.attackDamage", 2, Double.MAX_VALUE),
    HORSE_JUMP_STRENGTH("horse.jumpStrength", 0.7, 2),
    ZOMBIE_SPAWN_REINFORCEMENTS("zombie.spawnReinforcements", 0, 1);
    
    private final String name;
    private final double def,max;

    AttributeType(String name, double def, double max) {
        this.name = name;
        this.def = def;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public double getDef() {
        return def;
    }

    public double getMax() {
        return max;
    }
}

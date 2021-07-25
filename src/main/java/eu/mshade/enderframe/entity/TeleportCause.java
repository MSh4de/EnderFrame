package eu.mshade.enderframe.entity;

public enum TeleportCause {
    /**
     * Indicates the teleporation was caused by a player throwing an Ender
     * Pearl
     */
    ENDER_PEARL,
    /**
     * Indicates the teleportation was caused by a player executing a
     * command
     */
    COMMAND,
    /**
     * Indicates the teleportation was caused by a plugin
     */
    PLUGIN,
    /**
     * Indicates the teleportation was caused by a player entering a
     * Nether portal
     */
    NETHER_PORTAL,
    /**
     * Indicates the teleportation was caused by a player entering an End
     * portal
     */
    END_PORTAL,
    /**
     * Indicates the teleportation was caused by a player teleporting to a
     * Entity/Player via the specatator menu
     */
    SPECTATE,
    /**
     * Indicates the teleportation was caused by an event not covered by
     * this enum
     */
    UNKNOWN;
}

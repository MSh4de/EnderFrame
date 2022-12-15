package eu.mshade.enderframe.world.block.window;

import java.util.HashMap;
import java.util.Map;

public enum BeaconWindowProperty implements IWindowProperty {

    POWER_LEVEL(0),
    FIRST_POTION_EFFECT(1),
    SECOND_POTION_EFFECT(2);

    private static final Map<Integer, BeaconWindowProperty> BEACON_PROPERTY_BY_ID = new HashMap<>();

    static {
        for (BeaconWindowProperty beaconWindowProperty : values()) {
            BEACON_PROPERTY_BY_ID.put(beaconWindowProperty.getId(), beaconWindowProperty);
        }
    }

    private final int id;

    BeaconWindowProperty(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public static BeaconWindowProperty byId(int id) {
        return BEACON_PROPERTY_BY_ID.get(id);
    }
}

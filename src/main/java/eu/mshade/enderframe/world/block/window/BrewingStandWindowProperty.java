package eu.mshade.enderframe.world.block.window;

import java.util.HashMap;
import java.util.Map;

public enum BrewingStandWindowProperty implements IWindowProperty {

    BREW_TIME_LEFT(0);

    private static final Map<Integer, BrewingStandWindowProperty> BREWING_STAND_PROPERTY_BY_ID = new HashMap<>();

    static {
        for (BrewingStandWindowProperty brewingStandProperty : values()) {
            BREWING_STAND_PROPERTY_BY_ID.put(brewingStandProperty.getId(), brewingStandProperty);
        }
    }

    private final int id;

    BrewingStandWindowProperty(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public static BrewingStandWindowProperty byId(int id) {
        return BREWING_STAND_PROPERTY_BY_ID.get(id);
    }
}

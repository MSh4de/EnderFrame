package eu.mshade.enderframe.world.block.window;

import java.util.HashMap;
import java.util.Map;

public enum FurnaceWindowProperty implements IWindowProperty {

    FUEL_LEFT(0),
    FUEL_BURN_TIME(1),
    PROGRESS_ARROW(2);

    public static final int MAXIMUM_PROGRESS = 200;
    private static final Map<Integer, FurnaceWindowProperty> FURNACE_PROPERTY_BY_ID = new HashMap<>();

    static {
        for (FurnaceWindowProperty furnaceProperty : values()) {
            FURNACE_PROPERTY_BY_ID.put(furnaceProperty.getId(), furnaceProperty);
        }
    }

    private final int id;

    FurnaceWindowProperty(int id) {
        this.id = id;
    }


    @Override
    public int getId() {
        return this.id;
    }

    public static FurnaceWindowProperty byId(int id) {
        return FURNACE_PROPERTY_BY_ID.get(id);
    }
}

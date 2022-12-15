package eu.mshade.enderframe.world.block.window;

import java.util.HashMap;
import java.util.Map;

public enum AnvilWindowProperty implements IWindowProperty {

    REPAIR_COST(0);

    private static final Map<Integer, AnvilWindowProperty> ANVIL_PROPERTY_BY_ID = new HashMap<>();

    static {
        for (AnvilWindowProperty anvilProperty : values()) {
            ANVIL_PROPERTY_BY_ID.put(anvilProperty.getId(), anvilProperty);
        }
    }

    private final int id;

    AnvilWindowProperty(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public static AnvilWindowProperty byId(int id) {
        return ANVIL_PROPERTY_BY_ID.get(id);
    }
}

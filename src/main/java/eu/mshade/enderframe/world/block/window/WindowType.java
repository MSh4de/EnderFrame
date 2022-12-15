package eu.mshade.enderframe.world.block.window;

import java.util.HashMap;
import java.util.Map;

public enum WindowType {

    FURNACE(0),
    ENCHANTMENT_TABLE(1),
    BEACON(2),
    ANVIL(3),
    BREWING_STAND(4);

    private static final Map<Integer, WindowType> WINDOW_TYPE_BY_ID = new HashMap<>();

    static {
        for (WindowType windowType : values()) {
            WINDOW_TYPE_BY_ID.put(windowType.getId(), windowType);
        }
    }

    private final int id;

    WindowType(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static WindowType byId(int id) {
        return WINDOW_TYPE_BY_ID.get(id);
    }
}

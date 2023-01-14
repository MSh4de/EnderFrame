package eu.mshade.enderframe.mojang.chat;

import java.util.HashMap;
import java.util.Map;

public enum TextPosition {

    CHAT(0),
    SYSTEM(1),
    HOT_BAR(2);

    private final int id;

    private static final Map<Integer, TextPosition> TEXT_POSITION_BY_ID = new HashMap<>();

    static {
        for (TextPosition textPosition : values()) {
            TEXT_POSITION_BY_ID.put(textPosition.getId(), textPosition);
        }
    }

    TextPosition(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TextPosition from(int id) {
        return TEXT_POSITION_BY_ID.get(id);
    }
}

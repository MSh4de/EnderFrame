package eu.mshade.enderframe.world.block;

import java.util.HashMap;
import java.util.Map;

public enum DiggingStatus {

    STARTED(0),
    CANCELLED(1),
    FINISHED(2),
    DROP_ITEM_STACK(3),
    DROP_ITEM(4),
    SHOOT_ARROW_OR_FINISH_EATING(5);

    private int id;
    private final static Map<Integer, DiggingStatus> DIGGING_STATUS_BY_ID = new HashMap<>();

    static {
        for (DiggingStatus diggingStatus : DiggingStatus.values()) {
            DIGGING_STATUS_BY_ID.put(diggingStatus.getId(), diggingStatus);
        }
    }
    DiggingStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static DiggingStatus fromId(int id){
        return DIGGING_STATUS_BY_ID.get(id);
    }
}

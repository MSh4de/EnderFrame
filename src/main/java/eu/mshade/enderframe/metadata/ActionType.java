package eu.mshade.enderframe.metadata;

import java.util.HashMap;
import java.util.Map;

public enum ActionType {

    START_SNEAKING(0),
    STOP_SNEAKING(1),
    LEAVE_BED(2),
    START_SPRINTING(3),
    STOP_SPRINTING(4),
    JUMP_WITH_HORSE(5),
    OPEN_RIDDEN_HORSE_INVENTORY(6);

    final int index;
    private static final Map<Integer, ActionType> actionTypes = new HashMap<>();

    static {
        for (ActionType value : ActionType.values()) {
            actionTypes.put(value.getIndex(), value);
        }
    }

    ActionType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static ActionType getActionTypeByIndex(int index) {
        return actionTypes.get(index);
    }


}

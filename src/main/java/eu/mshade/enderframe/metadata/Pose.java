package eu.mshade.enderframe.metadata;

import java.util.Map;

public enum Pose {

    STANDING(0),
    FALL_FLYING(1),
    SLEEPING(2),
    SWIMMING(3),
    SPIN_ATTACK(4),
    SNEAKING(5),
    DYING(6);

    private final int id;

    Pose(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

package eu.mshade.enderframe.world.block;

import java.util.HashMap;
import java.util.Map;

public enum BlockShape {

    INNER_LEFT(0),
    INNER_RIGHT(1),
    OUTER_LEFT(2),
    OUTER_RIGHT(3),
    STRAIGHT(4);

    private int id;

    private final static Map<Integer, BlockShape> blockShapeById = new HashMap<>();

    static {
        for (BlockShape blockShape : values()) {
            blockShapeById.put(blockShape.getId(), blockShape);
        }
    }

    BlockShape(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static BlockShape fromId(int id){
        return blockShapeById.getOrDefault(id, STRAIGHT);
    }


}

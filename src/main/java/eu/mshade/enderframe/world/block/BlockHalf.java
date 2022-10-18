package eu.mshade.enderframe.world.block;

import java.util.HashMap;
import java.util.Map;

public enum BlockHalf {
    TOP(0),
    BOTTOM(1);

    private int id;
    private static final Map<Integer, BlockHalf> BLOCK_HALF_BY_ID = new HashMap<>();

    static {
        for (BlockHalf blockHalf : values()) {
            BLOCK_HALF_BY_ID.put(blockHalf.getId(), blockHalf);
        }
    }

    BlockHalf(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static BlockHalf fromId(int id) {
        return BLOCK_HALF_BY_ID.getOrDefault(id, BOTTOM);
    }

    public BlockHalf getOppositeHalf(){
        return this == TOP ? BOTTOM : TOP;
    }

    public static BlockHalf fromY(double y){
        return y <= 8 || y > 15 ? BOTTOM : TOP;
    }

}

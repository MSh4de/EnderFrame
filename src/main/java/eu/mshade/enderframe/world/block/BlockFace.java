package eu.mshade.enderframe.world.block;

import eu.mshade.enderframe.world.Vector;

import java.util.HashMap;
import java.util.Map;

public enum BlockFace {

    UP(1, 0, new Vector(0, 1, 0)),
    DOWN(0, 1, new Vector(0, -1, 0)),
    NORTH(2, 3, new Vector(0, 0, -1)),
    SOUTH(3, 2, new Vector(0, 0, 1)),
    EAST(5, 4, new Vector(1, 0, 0)),
    WEST(4, 5, new Vector(-1, 0, 0)),
    NONE(-1, -1, new Vector(0, 0, 0));

    private int id;
    private int oppositeBlockFace;
    private Vector vector;

    private final static Map<Integer, BlockFace> blockFaceById = new HashMap<>();

    static {
        for (BlockFace blockFace : values()) {
            blockFaceById.put(blockFace.getId(), blockFace);
        }
    }

    BlockFace(int id, int oppositeBlockFace, Vector vector) {
        this.id = id;
        this.oppositeBlockFace = oppositeBlockFace;
        this.vector = vector;
    }

    public int getId() {
        return this.id;
    }

    public BlockFace getOppositeFace(){
        return fromId(this.oppositeBlockFace);
    }

    public Vector getVector() {
        return vector;
    }

    public static BlockFace fromId(int id){
        return blockFaceById.getOrDefault(id, NONE);
    }
}

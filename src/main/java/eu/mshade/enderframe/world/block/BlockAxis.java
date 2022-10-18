package eu.mshade.enderframe.world.block;

import java.util.HashMap;
import java.util.Map;

public enum BlockAxis {

        X(0),
        Y(1),
        Z(2),
        NONE(3);

        private int id;

        private final static Map<Integer, BlockAxis> blockAxisById = new HashMap<>();

        static {
            for (BlockAxis blockAxis : values()) {
                blockAxisById.put(blockAxis.getId(), blockAxis);
            }
        }

        BlockAxis(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static BlockAxis fromId(int id){
            return blockAxisById.getOrDefault(id, NONE);
        }

}

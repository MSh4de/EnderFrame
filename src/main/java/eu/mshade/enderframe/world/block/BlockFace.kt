package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.world.Vector

enum class BlockFace(val id: Int, private val oppositeBlockFace: Int, val vector: Vector) {
    UP(1, 0, Vector(0, 1, 0)),
    DOWN(0, 1, Vector(0, -1, 0)),
    NORTH(2, 3, Vector(0, 0, -1)),
    SOUTH(3, 2, Vector(0, 0, 1)),
    EAST(5, 4, Vector(1, 0, 0)),
    WEST(4, 5, Vector(-1, 0, 0)),
    NONE(-1, -1, Vector(0, 0, 0));

    val oppositeFace: BlockFace
        get() = fromId(oppositeBlockFace)

    fun toAxis(): BlockAxis {
        return toAxis(this)
    }

    companion object {
        private val blockFaceById: MutableMap<Int, BlockFace> = HashMap()

        init {
            for (blockFace in values()) {
                blockFaceById[blockFace.id] = blockFace
            }
        }

        @JvmStatic
        fun fromId(id: Int): BlockFace {
            return blockFaceById.getOrDefault(id, NONE)
        }

        // get block face from direction -180 to 180 degrees
        fun fromDirection(yaw: Float): BlockFace {
            var yaw = yaw
            if (yaw < 0) {
                yaw += 360f
            }
            if (yaw >= 315 || yaw < 45) {
                return SOUTH
            } else if (yaw < 135) {
                return WEST
            } else if (yaw < 225) {
                return NORTH
            } else if (yaw < 315) {
                return EAST
            }
            return NONE
        }

        fun toAxis(blockFace: BlockFace?): BlockAxis {
            return when (blockFace) {
                UP, DOWN -> BlockAxis.Y
                NORTH, SOUTH -> BlockAxis.Z
                EAST, WEST -> BlockAxis.X
                else -> BlockAxis.NONE
            }
        }
    }
}

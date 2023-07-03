package eu.mshade.enderframe.world.block.redstone

import eu.mshade.enderframe.world.Vector
import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.block.Block
import eu.mshade.enderframe.world.block.BlockFace
import eu.mshade.enderframe.world.block.RedstoneState
import java.util.*
import kotlin.math.max

object Redstone {

    fun spreadPower(position: Vector, blockFace: BlockFace): List<Vector> {

        val positions = mutableListOf<Vector>()

        positions.add(position.clone().add(1, 0, 0))
        positions.add(position.clone().add(-1, 0, 0))
        positions.add(position.clone().add(0, 1, 0))
        positions.add(position.clone().add(0, -1, 0))
        positions.add(position.clone().add(0, 0, 1))
        positions.add(position.clone().add(0, 0, -1))

        val supportBlock = position.clone().add(blockFace.oppositeFace.vector)
        positions.add(supportBlock.clone().add(0, 1, 0))
        positions.add(supportBlock.clone().add(0, -1, 0))
        positions.add(supportBlock.clone().add(blockFace.oppositeFace.vector))

        when (blockFace) {
            BlockFace.NORTH, BlockFace.SOUTH, BlockFace.UP, BlockFace.DOWN -> {
                positions.add(supportBlock.clone().add(1, 0, 0))
                positions.add(supportBlock.clone().add(-1, 0, 0))
            }

            BlockFace.EAST, BlockFace.WEST, BlockFace.UP, BlockFace.DOWN -> {
                positions.add(supportBlock.clone().add(0, 0, 1))
                positions.add(supportBlock.clone().add(0, 0, -1))
            }

            else -> {

            }
        }

        return positions

    }

    fun filterSpreadPower(positions: List<Vector>, world: World): List<Pair<Vector, Block>> {
        val blocks = mutableListOf<Pair<Vector, Block>>()
        for (position in positions) {
            val block = world.getBlock(position)
            val redstoneState = block.getRedstoneState()
            if (redstoneState != RedstoneState.WIRE && redstoneState != RedstoneState.REPLICATION && redstoneState != RedstoneState.RECEIVING) {
                continue
            }
            blocks.add(position to block)
        }
        return blocks
    }

    fun filterSpreadSignal(position: Vector, world: World, neighborBlockPositions: List<Vector>): List<Vector>{
        val blocks = mutableListOf<Vector>()

        for (neighborBlockPosition in neighborBlockPositions) {
            val targetBlock = world.getBlock(neighborBlockPosition)
            if(!targetBlock.isTickable()) continue
            val redstoneState = targetBlock.getRedstoneState()
            if (redstoneState == RedstoneState.NONE) continue

            if (redstoneState == RedstoneState.REPLICATION){
                val expectedPosition = position.clone().subtract(targetBlock.getFace().vector)
                if(expectedPosition != neighborBlockPosition) continue
                blocks.add(neighborBlockPosition)
            }

            if (redstoneState == RedstoneState.RECEIVING || redstoneState == RedstoneState.WIRE){
                blocks.add(neighborBlockPosition)
            }
        }

        return blocks
    }

    fun getNeighborBlockPositions(position: Vector): MutableList<Vector> {
        val neighborPositions = mutableListOf<Vector>()

        // Définissez les déplacements possibles dans les quatre directions
        val directions = arrayOf(
            Vector(1, 0, 0),
            Vector(-1, 0, 0),
            Vector(0, 1, 0),
            Vector(0, -1, 0),
            Vector(0, 0, 1),
            Vector(0, 0, -1)
        )

        // Parcourez les directions pour trouver les positions voisines

        for (direction in directions) {
            val neighborPos = position.clone().add(direction)
            neighborPositions.add(neighborPos)
        }

        return neighborPositions
    }

    fun getBehindBlockPosition(position: Vector, facing: BlockFace): Vector {
        return position.clone().add(facing.vector)
    }

    fun getPower(world: World, position: Vector): Int {
        val block = world.getBlock(position)
        val redstoneState = block.getRedstoneState()
        if (redstoneState == RedstoneState.RECEIVING) return 0
        return block.getPower()
    }


    fun getHigherPower(world: World, positions: List<Vector>): Int {
        var power = -1
        for (position in positions) {
            val block = world.getBlock(position)
            val redstoneState = block.getRedstoneState()
            if (redstoneState == RedstoneState.RECEIVING) continue
            power = max(power, block.getPower())
        }
        return power
    }

    fun getHigherPower(world: World, positions: List<Vector>, position: Vector): Pair<Vector, Int> {
        var power = 0
        var powerPosition = Vector.ZERO

        for (pos in positions) {
            val block = world.getBlock(pos)
            val redstoneState = block.getRedstoneState()

            if (redstoneState == RedstoneState.REPLICATION && position.clone().add(block.getFace().vector) == pos) {
                if (block.getPower() > power) {
                    power = block.getPower()
                    powerPosition = pos
                }

            } else if (redstoneState == RedstoneState.EMITTING || redstoneState == RedstoneState.WIRE) {
                if (block.getPower() > power) {
                    power = block.getPower()
                    powerPosition = pos
                }
            }
        }


        return powerPosition to power
    }

    fun calculatePower(position: Vector, world: World, neighborPositions: List<Vector>): Int {
        var power = 0

        for (neighborPosition in neighborPositions) {
            val neighborBlock = world.getBlock(neighborPosition)
            val redstoneState = neighborBlock.getRedstoneState()
            // Vérifier si le voisin est un composant de redstone actif
            if (redstoneState != RedstoneState.RECEIVING && redstoneState != RedstoneState.NONE && neighborBlock.hasPower()) {
                val neighborPower = neighborBlock.getPower()
                // Réduire la puissance du voisin si nécessaire en fonction de la distance entre les blocs
                val distance = position.taxicabDistance(neighborPosition)
                val reducedPower = neighborPower - distance
                // Mettre à jour la puissance du bloc de redstone
                power = max(power, reducedPower.toInt())
            }
        }

        return power
    }


    fun findClosestEmitter(world: World, position: Vector): Vector? {
        val queue = ArrayDeque<Vector>()
        val visited = mutableSetOf<Vector>()

        queue.add(position)
        visited.add(position)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            val block = world.getBlock(current)
            val redstoneState = block.getRedstoneState()

            if (redstoneState == RedstoneState.EMITTING || redstoneState == RedstoneState.WIRE) {
                return current // Bloc émetteur trouvé, on le retourne
            }

            // Ajouter les positions adjacentes non visitées à la file d'attente
            for (neighbor in getNeighborBlockPositions(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor)
                    visited.add(neighbor)
                }
            }
        }

        return null // Aucun bloc émetteur trouvé
    }


}
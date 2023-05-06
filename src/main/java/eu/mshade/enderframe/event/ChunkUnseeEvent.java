package eu.mshade.enderframe.event;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.world.chunk.Chunk;

public class ChunkUnseeEvent extends MinecraftEvent {

    private final Chunk chunk;
    private final Player player;

    public ChunkUnseeEvent(Chunk chunk, Player player) {
        this.chunk = chunk;
        this.player = player;
    }

    public Chunk getChunkBuffer() {
        return chunk;
    }

    public Player getPlayer() {
        return player;
    }
}

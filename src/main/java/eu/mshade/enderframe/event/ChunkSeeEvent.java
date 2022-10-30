package eu.mshade.enderframe.event;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.world.Chunk;

public class ChunkSeeEvent extends EnderFrameEvent {

    private final Chunk chunk;
    private final Player player;

    public ChunkSeeEvent(Chunk chunk, Player player) {
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

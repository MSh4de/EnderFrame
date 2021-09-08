package eu.mshade.enderframe.event;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.world.ChunkBuffer;

public class ChunkUnloadEvent extends EnderFrameEvent {

    private final ChunkBuffer chunkBuffer;

    public ChunkUnloadEvent(ChunkBuffer chunkBuffer) {
        this.chunkBuffer = chunkBuffer;
    }

    public ChunkBuffer getChunkBuffer() {
        return chunkBuffer;
    }

}

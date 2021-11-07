package eu.mshade.enderframe.event;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.event.EnderFrameEvent;
import eu.mshade.enderframe.world.ChunkBuffer;

public class ChunkLoadEvent extends EnderFrameEvent {

    private final ChunkBuffer chunkBuffer;

    public ChunkLoadEvent(ChunkBuffer chunkBuffer) {
        this.chunkBuffer = chunkBuffer;
    }

    public ChunkBuffer getChunkBuffer() {
        return chunkBuffer;
    }

}

package eu.mshade.enderframe.event;

import eu.mshade.enderframe.world.ChunkBuffer;

public class WatchdogUnseeEvent extends EnderFrameEvent {

    private final ChunkBuffer chunkBuffer;

    public WatchdogUnseeEvent(ChunkBuffer chunkBuffer) {
        this.chunkBuffer = chunkBuffer;
    }

    public ChunkBuffer getChunkBuffer() {
        return chunkBuffer;
    }
}

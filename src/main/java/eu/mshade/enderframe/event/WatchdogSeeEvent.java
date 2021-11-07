package eu.mshade.enderframe.event;

import eu.mshade.enderframe.world.ChunkBuffer;

public class WatchdogSeeEvent extends EnderFrameEvent {

    private final ChunkBuffer chunkBuffer;

    public WatchdogSeeEvent(ChunkBuffer chunkBuffer) {
        this.chunkBuffer = chunkBuffer;
    }

    public ChunkBuffer getChunkBuffer() {
        return chunkBuffer;
    }
}

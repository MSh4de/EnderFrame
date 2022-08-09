package eu.mshade.enderframe.world.chunk;

import eu.mshade.enderframe.world.ChunkStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class ChunkStateStore {

    protected ChunkStatus chunkStatus;
    protected ChunkStatus lastChunkStatus;
    protected Map<ChunkStatus, Long> trackedTime = new HashMap<>();
    protected AtomicBoolean inChunkSafeguard = new AtomicBoolean(false);
    protected AtomicLong 



}

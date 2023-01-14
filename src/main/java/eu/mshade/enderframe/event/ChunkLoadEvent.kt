package eu.mshade.enderframe.event

import eu.mshade.enderframe.world.chunk.Chunk
import java.util.concurrent.CompletableFuture

data class ChunkLoadEvent(val chunk: CompletableFuture<Chunk>) : EnderFrameEvent()
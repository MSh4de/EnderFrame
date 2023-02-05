package eu.mshade.enderframe.event

import eu.mshade.enderframe.world.chunk.Chunk

data class ChunkCreateEvent(var chunk: Chunk) : EnderFrameEvent()
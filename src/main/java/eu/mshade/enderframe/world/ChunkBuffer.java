package eu.mshade.enderframe.world;


import eu.mshade.enderframe.EnderFrameSession;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public interface ChunkBuffer {

    int getX();

    int getZ();

    UUID getId();


    Collection<EnderFrameSession> getViewers();

    WorldBuffer getWorldBuffer();

    SectionBuffer[] getSectionBuffers();

    AtomicLong getHealth();

    File getFile();

    int getBitMask();

    int getBlock(int x, int y, int z);

    void setBlock(int x, int y, int z, int block);

    byte getBlockLight(int x, int y, int z);

    void setBlockLight(int x, int y, int z, byte light);

    byte getSkyLight(int x, int y, int z);

    void setSkyLight(int x, int y, int z, byte light);

    void setBiome(int x, int z, int biome);

    int getBiome(int x, int z);

    byte[] getBiomes();

    int getHighest(int x, int z);

    boolean hasChange();

    static UUID ofId(int x, int z){
        return UUID.nameUUIDFromBytes(String.format("%d,%d", x, z).getBytes(StandardCharsets.UTF_8));
    }

}

package eu.mshade.enderframe.world;


import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.mwork.binarytag.poet.BinaryTagPoet;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public interface Chunk {

    int getX();

    int getZ();

    UUID getId();

    Queue<Player> getViewers();

    World getWorld();

    Section[] getSections();

    AtomicLong getHealth();

    int getBitMask();

    int getBlock(int x, int y, int z);

    void setBlock(int x, int y, int z, MaterialKey block);

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

    Queue<Entity> getEntities();

    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    void clearEntities();




}

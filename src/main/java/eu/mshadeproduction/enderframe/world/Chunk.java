package eu.mshadeproduction.enderframe.world;

import eu.mshadeproduction.enderframe.entity.Player;

import java.util.Set;

public interface Chunk {

    int getX();

    int getZ();

    int getID();

    void setBlock(int x, int y, int z, Block block);

    Block getBlock(int x, int y, int z);

    Set<Player> getViewers();

    Palette getPalette();

}

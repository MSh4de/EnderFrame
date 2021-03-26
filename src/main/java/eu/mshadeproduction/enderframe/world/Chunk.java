package eu.mshadeproduction.enderframe.world;

import eu.mshadeproduction.enderframe.entity.Player;

import java.util.Set;

public interface Chunk {

    int getX();

    int getZ();

    Set<Player> getViewers();


}

package eu.mshade.enderframe;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.protocol.SessionWrapper;

import java.util.Collection;
import java.util.function.Consumer;

public interface Watchable {

    void addWatcher(Agent agent);

    void removeWatcher(Agent agent);

    Collection<Agent> getWatching();

    boolean isWatching(Agent agent);

    void notify(Consumer<Agent> sessionWrapperConsumer);

}

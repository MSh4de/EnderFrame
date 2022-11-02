package eu.mshade.enderframe;

import java.util.Collection;
import java.util.function.Consumer;

public interface Watchable {

    void addWatcher(Agent agent);

    void removeWatcher(Agent agent);

    Collection<Agent> getWatchers();

    boolean isWatching(Agent agent);

    void notify(Consumer<Agent> sessionWrapperConsumer);

}

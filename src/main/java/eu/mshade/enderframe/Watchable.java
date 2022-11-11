package eu.mshade.enderframe;

import java.util.Collection;
import java.util.function.Consumer;


public interface Watchable {

    void addWatcher(Agent agent);

    void removeWatcher(Agent agent);

    Collection<Agent> getWatcher();

    boolean isWatching(Agent agent);

    void notify(Consumer<Agent> agent);

    default <T extends Agent> void notify(Class<T> type, Consumer<T> consumer) {
        notify(agent -> {
            if (type.isInstance(agent)) consumer.accept(type.cast(agent));
        });
    }

}

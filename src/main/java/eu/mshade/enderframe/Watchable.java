package eu.mshade.enderframe;

import java.util.Collection;
import java.util.function.Consumer;

public interface Watchable {

    void addWatcher(Agent agent);

    void removeWatcher(Agent agent);

    boolean isWatching(Agent agent);

    Collection<Agent> getWatchers();

    default void notify(Consumer<Agent> agent){
        for (Agent a : getWatchers()) agent.accept(a);
    }

    default <T extends Agent> void notify(Class<T> agentClass, Consumer<T> agent){
        for (Agent a : getWatchers()) {
            if (agentClass.isInstance(a)) agent.accept((T) a);
        }
    }

}

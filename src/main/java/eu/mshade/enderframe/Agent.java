package eu.mshade.enderframe;

import java.util.Collection;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public interface Agent {

    String getAgent();

    void joinWatch(Watchable watchable);

    void leaveWatch(Watchable watchable);

    Collection<Watchable> getWatchings();

    static Agent from(String name) {
        return new DefaultAgent(name);
    }

    class DefaultAgent implements Agent {

        private final String name;
        private final Queue<Watchable> watchables = new ConcurrentLinkedQueue<>();

        public DefaultAgent(String name) {
            this.name = name;
        }

        @Override
        public String getAgent() {
            return name;
        }

        @Override
        public void joinWatch(Watchable watchable) {
            watchable.addWatcher(this);
            watchables.add(watchable);
        }

        @Override
        public void leaveWatch(Watchable watchable) {
            watchables.remove(watchable);
            watchable.removeWatcher(this);
        }

        @Override
        public Collection<Watchable> getWatchings() {
            return this.watchables;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if(o == this) return true;
            if(!(o instanceof Agent agent)) return false;
            return Objects.equals(name, agent.getAgent());
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

}

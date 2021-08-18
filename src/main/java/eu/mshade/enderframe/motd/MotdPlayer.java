package eu.mshade.enderframe.motd;

import java.util.ArrayList;
import java.util.List;

public class MotdPlayer {

    private int max, online;
    private List<MotdPlayerEntry> sample = new ArrayList<>();

    private MotdPlayer() {
    }

    public MotdPlayer(int max, int online) {
        this.max = max;
        this.online = online;
    }

    public int getMax() {
        return max;
    }

    public int getOnline() {
        return online;
    }

    public MotdPlayer addSample(MotdPlayerEntry motdPlayerEntry){
        this.sample.add(motdPlayerEntry);
        return this;
    }

    public List<MotdPlayerEntry> getSample() {
        return sample;
    }


    @Override
    public String toString() {
        return "MotdPlayer{" +
                "max=" + max +
                ", online=" + online +
                ", sample=" + sample +
                '}';
    }
}

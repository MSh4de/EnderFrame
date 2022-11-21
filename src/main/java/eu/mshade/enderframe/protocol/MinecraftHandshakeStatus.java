package eu.mshade.enderframe.protocol;

import java.util.HashMap;
import java.util.Map;

public enum MinecraftHandshakeStatus {

    STATUS(1),
    LOGIN(2);

    private final int state;
    private final static Map<Integer, MinecraftHandshakeStatus> MAP = new HashMap<>();

    static {
        for (MinecraftHandshakeStatus minecraftHandshakeStatus : MinecraftHandshakeStatus.values()) {
            MAP.put(minecraftHandshakeStatus.getState(), minecraftHandshakeStatus);
        }
    }

    MinecraftHandshakeStatus(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public static MinecraftHandshakeStatus getHandShakeStatus(int state){
        return MAP.get(state);
    }

}

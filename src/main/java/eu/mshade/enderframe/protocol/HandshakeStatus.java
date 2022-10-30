package eu.mshade.enderframe.protocol;

import java.util.HashMap;
import java.util.Map;

public enum HandshakeStatus {

    STATUS(1),
    LOGIN(2);

    private final int state;
    private final static Map<Integer, HandshakeStatus> MAP = new HashMap<>();

    static {
        for (HandshakeStatus handshakeStatus : HandshakeStatus.values()) {
            MAP.put(handshakeStatus.getState(), handshakeStatus);
        }
    }

    HandshakeStatus(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public static HandshakeStatus getHandShakeStatus(int state){
        return MAP.get(state);
    }

}

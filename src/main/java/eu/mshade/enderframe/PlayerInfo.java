package eu.mshade.enderframe;

import java.util.List;

public class PlayerInfo {

    private final PlayerInfoType playerInfoType;
    private final List<EnderFrameSession> enderFrameSessions;

    public PlayerInfo(PlayerInfoType playerInfoType, List<EnderFrameSession> enderFrameSessions) {
        this.playerInfoType = playerInfoType;
        this.enderFrameSessions = enderFrameSessions;
    }

    public PlayerInfoType getPlayerInfoType() {
        return playerInfoType;
    }

    public List<EnderFrameSession> getEnderFrameSessions() {
        return enderFrameSessions;
    }

    @Override
    public String toString() {
        return "PlayerInfo{" +
                "playerInfoType=" + playerInfoType +
                ", enderFrameSessions=" + enderFrameSessions +
                '}';
    }
}

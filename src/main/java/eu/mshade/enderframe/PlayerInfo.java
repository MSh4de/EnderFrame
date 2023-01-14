package eu.mshade.enderframe;

import eu.mshade.enderframe.entity.Player;

import java.util.List;

public class PlayerInfo {

    private final PlayerInfoType playerInfoType;
    private final List<Player> players;

    public PlayerInfo(PlayerInfoType playerInfoType, List<Player> players) {
        this.playerInfoType = playerInfoType;
        this.players = players;
    }

    public PlayerInfoType getPlayerInfoType() {
        return playerInfoType;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "PlayerInfo{" +
                "playerInfoType=" + playerInfoType +
                ", enderFrameSessions=" + players +
                '}';
    }
}

package eu.mshade.enderframe;

import eu.mshade.enderframe.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerInfoBuilder {

    private PlayerInfoType playerInfoType;
    private List<Player> players = new ArrayList<>();

    private PlayerInfoBuilder(PlayerInfoType playerInfoType) {
        this.playerInfoType = playerInfoType;
    }

    public static PlayerInfoBuilder of(PlayerInfoType playerInfoType){
        return new PlayerInfoBuilder(playerInfoType);
    }

    public PlayerInfoBuilder withPlayer(Player player){
        this.players.add(player);
        return this;
    }

    public PlayerInfo build(){
        return new PlayerInfo(playerInfoType, players);
    }


}

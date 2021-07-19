package eu.mshade.enderframe;

import java.util.ArrayList;
import java.util.List;

public class PlayerInfoBuilder {

    private PlayerInfoType playerInfoType;
    private List<EnderFrameSession> enderFrameSessions = new ArrayList<>();

    private PlayerInfoBuilder(PlayerInfoType playerInfoType) {
        this.playerInfoType = playerInfoType;
    }

    public static PlayerInfoBuilder of(PlayerInfoType playerInfoType){
        return new PlayerInfoBuilder(playerInfoType);
    }

    public PlayerInfoBuilder withPlayer(EnderFrameSession enderFrameSession){
        this.enderFrameSessions.add(enderFrameSession);
        return this;
    }

    public PlayerInfo build(){
        return new PlayerInfo(playerInfoType, enderFrameSessions);
    }


}

package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.PlayerInfo;
import eu.mshade.enderframe.PlayerInfoBuilder;
import eu.mshade.enderframe.PlayerInfoType;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.mojang.GameProfile;
import eu.mshade.enderframe.protocol.PacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

import java.util.List;

public class PacketOutPlayerInfo implements PacketOut {

    private final PlayerInfo playerInfo;

    public PacketOutPlayerInfo(PlayerInfoBuilder playerInfoBuilder) {
        this.playerInfo = playerInfoBuilder.build();
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        PlayerInfoType playerInfoType = playerInfo.getPlayerInfoType();
        List<Player> players = playerInfo.getPlayers();

        protocolBuffer.writeVarInt(playerInfoType.ordinal());
        protocolBuffer.writeVarInt(players.size());

        for (Player player : players) {
            GameProfile gameProfile = player.getGameProfile();
            protocolBuffer.writeUUID(gameProfile.getId());
            boolean present = player.getDisplayName() != null;

            switch (playerInfoType) {
                case ADD_PLAYER:
                    protocolBuffer.writeString(gameProfile.getName());
                    protocolBuffer.writeVarInt(gameProfile.getProperties().size());
                    gameProfile.getProperties().forEach((s, property) -> {
                        protocolBuffer.writeString(property.getName());
                        protocolBuffer.writeString(property.getValue());
                        protocolBuffer.writeBoolean(property.getSignature() != null);
                        if (property.getSignature() != null) protocolBuffer.writeString(property.getSignature());

                    });
                    protocolBuffer.writeVarInt(player.getGameMode().getId());
                    protocolBuffer.writeVarInt(player.getPing());

                    protocolBuffer.writeBoolean(present);
                    if (present) protocolBuffer.writeString(player.getDisplayName());
                break;
                case UPDATE_GAMEMODE:
                    protocolBuffer.writeVarInt(player.getGameMode().getId());
                    break;
                case UPDATE_LATENCY:
                    protocolBuffer.writeVarInt(player.getPing());
                    break;
                case UPDATE_DISPLAY_NAME:
                    protocolBuffer.writeBoolean(present);
                    if (present) protocolBuffer.writeString(player.getDisplayName());
                break;
                case REMOVE_PLAYER:
                    break;
            }
        }
    }
}

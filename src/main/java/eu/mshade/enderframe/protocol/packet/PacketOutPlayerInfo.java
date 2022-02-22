package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.PlayerInfo;
import eu.mshade.enderframe.PlayerInfoBuilder;
import eu.mshade.enderframe.PlayerInfoType;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.mojang.GameProfile;
import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketOut;

import java.util.List;

public class PacketOutPlayerInfo extends PacketOut {

    private final PlayerInfo playerInfo;

    public PacketOutPlayerInfo(PlayerInfoBuilder playerInfoBuilder) {
        this.playerInfo = playerInfoBuilder.build();
    }

    @Override
    public void serialize(ByteMessage byteMessage) {
        PlayerInfoType playerInfoType = playerInfo.getPlayerInfoType();
        List<Player> players = playerInfo.getPlayers();

        byteMessage.writeVarInt(playerInfoType.ordinal());
        byteMessage.writeVarInt(players.size());

        for (Player player : players) {
            GameProfile gameProfile = player.getGameProfile();
            byteMessage.writeUUID(gameProfile.getId());

            switch (playerInfoType) {
                case ADD_PLAYER:
                    byteMessage.writeString(gameProfile.getName());
                    byteMessage.writeVarInt(gameProfile.getProperties().size());
                    gameProfile.getProperties().forEach((s, property) -> {
                        byteMessage.writeString(property.getName());
                        byteMessage.writeString(property.getValue());
                        byteMessage.writeBoolean(property.getSignature().isPresent());
                        property.getSignature().ifPresent(byteMessage::writeString);
                    });
                    byteMessage.writeVarInt(player.getGameMode().getId());
                    byteMessage.writeVarInt(player.getPing());
                    byteMessage.writeBoolean(player.getPlayerListName().isPresent());
                    player.getPlayerListName().ifPresent(byteMessage::writeString);
                    break;
                case UPDATE_GAMEMODE:
                    byteMessage.writeVarInt(player.getGameMode().getId());
                    break;
                case UPDATE_LATENCY:
                    byteMessage.writeVarInt(player.getPing());
                    break;
                case UPDATE_DISPLAY_NAME:
                    byteMessage.writeBoolean(player.getPlayerListName().isPresent());
                    player.getPlayerListName().ifPresent(byteMessage::writeString);
                    break;
                case REMOVE_PLAYER:
                    break;
            }
        }
    }
}

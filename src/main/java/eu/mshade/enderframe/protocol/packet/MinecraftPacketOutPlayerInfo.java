package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.PlayerInfo;
import eu.mshade.enderframe.PlayerInfoBuilder;
import eu.mshade.enderframe.PlayerInfoType;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.mojang.GameProfile;
import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.MinecraftByteBuf;

import java.util.List;

public class MinecraftPacketOutPlayerInfo implements MinecraftPacketOut {

    private final PlayerInfo playerInfo;

    public MinecraftPacketOutPlayerInfo(PlayerInfoBuilder playerInfoBuilder) {
        this.playerInfo = playerInfoBuilder.build();
    }

    @Override
    public void serialize(MinecraftByteBuf minecraftByteBuf) {
        PlayerInfoType playerInfoType = playerInfo.getPlayerInfoType();
        List<Player> players = playerInfo.getPlayers();

        minecraftByteBuf.writeVarInt(playerInfoType.ordinal());
        minecraftByteBuf.writeVarInt(players.size());

        for (Player player : players) {
            GameProfile gameProfile = player.getGameProfile();
            minecraftByteBuf.writeUUID(gameProfile.getId());
            boolean present = player.getDisplayName() != null;

            switch (playerInfoType) {
                case ADD_PLAYER:
                    minecraftByteBuf.writeString(gameProfile.getName());
                    minecraftByteBuf.writeVarInt(gameProfile.getProperties().size());
                    gameProfile.getProperties().forEach((s, property) -> {
                        minecraftByteBuf.writeString(property.getName());
                        minecraftByteBuf.writeString(property.getValue());
                        minecraftByteBuf.writeBoolean(property.getSignature() != null);
                        if (property.getSignature() != null) minecraftByteBuf.writeString(property.getSignature());

                    });
                    minecraftByteBuf.writeVarInt(player.getGameMode().getId());
                    minecraftByteBuf.writeVarInt(player.getPing());

                    minecraftByteBuf.writeBoolean(present);
                    if (present) minecraftByteBuf.writeString(player.getDisplayName());
                break;
                case UPDATE_GAMEMODE:
                    minecraftByteBuf.writeVarInt(player.getGameMode().getId());
                    break;
                case UPDATE_LATENCY:
                    minecraftByteBuf.writeVarInt(player.getPing());
                    break;
                case UPDATE_DISPLAY_NAME:
                    minecraftByteBuf.writeBoolean(present);
                    if (present) minecraftByteBuf.writeString(player.getDisplayName());
                break;
                case REMOVE_PLAYER:
                    break;
            }
        }
    }
}

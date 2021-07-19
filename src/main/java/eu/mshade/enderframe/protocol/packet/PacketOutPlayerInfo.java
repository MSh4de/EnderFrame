package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.EnderFrameSession;
import eu.mshade.enderframe.PlayerInfo;
import eu.mshade.enderframe.PlayerInfoBuilder;
import eu.mshade.enderframe.PlayerInfoType;
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
        List<EnderFrameSession> enderFrameSessions = playerInfo.getEnderFrameSessions();

        byteMessage.writeVarInt(playerInfoType.ordinal());
        byteMessage.writeVarInt(enderFrameSessions.size());

        for (EnderFrameSession enderFrameSession : enderFrameSessions) {
            GameProfile gameProfile = enderFrameSession.getGameProfile();
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
                    byteMessage.writeVarInt(enderFrameSession.getGameMode().getId());
                    byteMessage.writeVarInt(enderFrameSession.getPing());
                    byteMessage.writeBoolean(enderFrameSession.getDisplayName().isPresent());
                    enderFrameSession.getDisplayName().ifPresent(byteMessage::writeString);
                    break;
                case UPDATE_GAMEMODE:
                    byteMessage.writeVarInt(enderFrameSession.getGameMode().getId());
                    break;
                case UPDATE_LATENCY:
                    byteMessage.writeVarInt(enderFrameSession.getPing());
                    break;
                case UPDATE_DISPLAY_NAME:
                    byteMessage.writeBoolean(enderFrameSession.getDisplayName().isPresent());
                    enderFrameSession.getDisplayName().ifPresent(byteMessage::writeString);
                    break;
                case REMOVE_PLAYER:
                    break;
            }
        }
    }
}

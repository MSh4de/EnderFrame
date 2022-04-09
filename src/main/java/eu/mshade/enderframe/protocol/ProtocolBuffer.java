package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.PlayerInfoBuilder;
import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.metadata.EntityMetadataType;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.mojang.chat.TextPosition;
import eu.mshade.enderframe.world.BlockPosition;
import eu.mshade.enderframe.world.ChunkBuffer;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.SectionBuffer;
import eu.mshade.mwork.MWork;
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.ByteBufUtil;

import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.util.UUID;

public interface ProtocolBuffer {

    default int readVarInt(ByteBuf byteBuf) {
        int numRead = 0;
        int result = 0;
        byte read;
        do {
            read = byteBuf.readByte();
            int value = (read & 0b01111111);
            result |= (value << (7 * numRead));

            numRead++;
            if (numRead > 5) {
                throw new RuntimeException("VarInt is too big");
            }
        } while ((read & 0b10000000) != 0);
        return result;
    }

    default void writeVarInt(ByteBuf byteBuf, int value) {
        do {
            byte temp = (byte)(value & 0b01111111);
            value >>>= 7;
            if (value != 0) {
                temp |= 0b10000000;
            }
            byteBuf.writeByte(temp);
        } while (value != 0);
    }

    default long readVarLong(ByteBuf byteBuf) {
        int numRead = 0;
        long result = 0;
        byte read;
        do {
            read = byteBuf.readByte();
            long value = (read & 0b01111111);
            result |= (value << (7 * numRead));

            numRead++;
            if (numRead > 10) {
                throw new RuntimeException("VarLong is too big");
            }
        } while ((read & 0b10000000) != 0);

        return result;
    }

    default void writeVarLong(ByteBuf byteBuf, long value) {
        do {
            byte temp = (byte)(value & 0b01111111);
            value >>>= 7;
            if (value != 0) {
                temp |= 0b10000000;
            }
            byteBuf.writeByte(temp);
        } while (value != 0);
    }

    default void writeUUID(ByteBuf byteBuf, UUID uuid){
        byteBuf.writeLong(uuid.getMostSignificantBits());
        byteBuf.writeLong(uuid.getLeastSignificantBits());
    }

    default UUID readUUID(ByteBuf byteBuf){
        return new UUID(byteBuf.readLong(), byteBuf.readLong());
    }

    default void writeBlockPosition(ByteBuf byteBuf, BlockPosition blockLocation) {

        long x = blockLocation.getX();
        long y = blockLocation.getY();
        long z = blockLocation.getZ();
        byteBuf.writeLong(((x & 0x3FFFFFF) << 38) | ((y & 0xFFF) << 26) | (z & 0x3FFFFFF));

    }

    default BlockPosition readBlockPosition(ByteBuf byteBuf) {
        long val = byteBuf.readLong();
        int x = (int) (val >> 38);
        int y = (int) ((val >> 26) & 0xFFF);
        int z = (int) (val << 38 >> 38);

        if (x >= (2 ^ 25)) x -= 2 ^ 26;
        if (y >= (2 ^ 11)) y -= 2 ^ 12;
        if (z >= (2 ^ 25)) z -= 2 ^ 26;

        return new BlockPosition(x, y, z);
    }

    default void writeByteArray(ByteBuf byteBuf, byte[] bytes){
        writeVarInt(byteBuf, bytes.length);
        byteBuf.writeBytes(bytes);
    }

    default byte[] readByteArray(ByteBuf byteBuf){
        byte[] bytes = new byte[this.readVarInt(byteBuf)];
        byteBuf.readBytes(bytes);
        return bytes;
    }

    default String readString(ByteBuf byteBuf) {
        return readString(byteBuf, readVarInt(byteBuf));
    }

    default String readString(ByteBuf byteBuf, int length) {
        String str = byteBuf.toString(byteBuf.readerIndex(), length, StandardCharsets.UTF_8);
        byteBuf.skipBytes(length);
        return str;
    }

    default void writeString(ByteBuf byteBuf, CharSequence str) {
        int size = ByteBufUtil.utf8Bytes(str);
        writeVarInt(byteBuf, size);
        byteBuf.writeCharSequence(str, StandardCharsets.UTF_8);
    }

    void writeItemStack(ByteBuf byteBuf, ItemStack itemStack);

    ItemStack readItemStack(ByteBuf byteBuf);

    default CompoundBinaryTag readCompoundBinaryTag(ByteBuf byteBuf) {
        return MWork.get().getBinaryTagBufferDriver().readCompoundBinaryTag(new ByteBufInputStream(byteBuf));
    }

    default void writeCompoundBinaryTag(ByteBuf byteBuf, CompoundBinaryTag compoundTag) {
        MWork.get().getBinaryTagBufferDriver().writeCompoundBinaryTag(compoundTag, new ByteBufOutputStream(byteBuf));
    }

    void sendHeadAndFooter(Player player, String header, String footer);

    void sendAbilities(Player player);

    void sendKeepAlive(Player player, int threshold);

    void sendEncryption(Player player, PublicKey publicKey);

    void sendPlayerInfo(Player player, PlayerInfoBuilder playerInfoBuilder);

    void sendMessage(Player player, TextComponent textComponent, TextPosition textPosition);

    void sendMessage(Player player, TextComponent textComponent);

    void sendMessage(Player player, String message);

    void disconnect(Player player, String message);

    void teleport(Player player, Location location);

    void sendUpdateLocation(Player player, Entity entity);

    void sendTeleport(Player player, Entity entity);

    void sendMove(Player player, Entity entity);

    void sendMoveAndLook(Player player, Entity entity);

    void sendLook(Player player, Entity entity);

    void sendHeadLook(Player player, Entity entity);

    void sendEntity(Player player, Entity... entities);

    void removeEntity(Player player, Entity... entities);

    void sendMetadata(Player player, Entity entity, EntityMetadataType... entityMetadataTypes);

    void sendChunk(Player player, ChunkBuffer chunkBuffer);

    void sendSection(Player player, SectionBuffer sectionBuffer);

    void sendUnloadChunk(Player player, ChunkBuffer chunkBuffer);

}

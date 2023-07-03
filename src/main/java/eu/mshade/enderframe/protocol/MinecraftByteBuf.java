package eu.mshade.enderframe.protocol;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.metadata.EntityMetadataKey;
import eu.mshade.enderframe.item.ItemStack;

import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.world.Vector;
import eu.mshade.mwork.MWork;
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag;
import io.netty.buffer.*;
import io.netty.util.ByteProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.UUID;

public abstract class MinecraftByteBuf extends ByteBuf {

    private static Logger LOGGER = LoggerFactory.getLogger(MinecraftByteBuf.class);

    private final ByteBuf byteBuf;

    public MinecraftByteBuf(ByteBuf byteBuf) {
        this.byteBuf = byteBuf;
    }

    public int readVarInt() {
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

    public void writeVarInt(int value) {
        do {
            byte temp = (byte)(value & 0b01111111);
            value >>>= 7;
            if (value != 0) {
                temp |= 0b10000000;
            }
            byteBuf.writeByte(temp);
        } while (value != 0);
    }

    public void writeVarIntArray(int[] value) {
        writeVarInt(value.length);

        for (int i = 0; i < value.length; i++) {
            writeVarInt(value[i]);
        }
    }

    public long readVarLong() {
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

    public void writeVarLong(long value) {
        do {
            byte temp = (byte)(value & 0b01111111);
            value >>>= 7;
            if (value != 0) {
                temp |= 0b10000000;
            }
            byteBuf.writeByte(temp);
        } while (value != 0);
    }

    public void writeUUID(UUID uuid){
        byteBuf.writeLong(uuid.getMostSignificantBits());
        byteBuf.writeLong(uuid.getLeastSignificantBits());
    }

    public UUID readUUID(){
        return new UUID(byteBuf.readLong(), byteBuf.readLong());
    }

    public void writeBlockPosition(Vector vector) {

        long x = vector.getBlockX();
        long y = vector.getBlockY();
        long z = vector.getBlockZ();
        byteBuf.writeLong(((x & 0x3FFFFFF) << 38) | ((y & 0xFFF) << 26) | (z & 0x3FFFFFF));

    }

    public Vector readBlockPosition() {
        long val = byteBuf.readLong();
        if (val == -1){
            return Vector.ZERO;
        }

        long x = (val >> 38);
        long y = (val >> 26) & 0xfff;
        long z = (val << 38) >> 38;

        return new Vector((int) x, (int) y, (int) z);
    }

    public void writeByteArray(byte[] bytes){
        writeVarInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }

    public byte[] readByteArray(){
        byte[] bytes = new byte[this.readVarInt()];
        byteBuf.readBytes(bytes);
        return bytes;
    }

    public String readString() {
        return readString(readVarInt());
    }

    public String readString(int length) {
        String str = byteBuf.toString(byteBuf.readerIndex(), length, StandardCharsets.UTF_8);
        byteBuf.skipBytes(length);
        return str;
    }

    public void writeString(CharSequence str) {
        int size = ByteBufUtil.utf8Bytes(str);
        writeVarInt(size);
        byteBuf.writeCharSequence(str, StandardCharsets.UTF_8);
    }

    public abstract void writeItemStack(ItemStack itemStack);

    public abstract ItemStack readItemStack();

    public CompoundBinaryTag readCompoundBinaryTag() {
        return EnderFrame.get().getBinaryTagDriver().readCompoundBinaryTag(new ByteBufInputStream(byteBuf));
    }

    public void writeCompoundBinaryTag(CompoundBinaryTag compoundTag) {
        EnderFrame.get().getBinaryTagDriver().writeCompoundBinaryTag(compoundTag, new ByteBufOutputStream(byteBuf));
    }

    public void writeValueAsString(Object o){
        try {
            String s = MWork.INSTANCE.getObjectMapper().writeValueAsString(o);
            this.writeString(s);
        }catch (JsonProcessingException e){
            LOGGER.error(e.getMessage(), e);
        }
    }

    public byte[] raw(){
        int length = this.byteBuf.readableBytes();
        byte[] payload = new byte[length];
        this.byteBuf.readBytes(payload);
        return payload;
    }
    public abstract void writeEntityMetadata(Entity entity, MetadataKey... entityMetadataKey);

    public abstract Collection<MetadataKey> getSupportedMetadataKeys(Entity entity);

    @Override
    public int capacity() {
        return byteBuf.capacity();
    }

    @Override
    public ByteBuf capacity(int newCapacity) {
        return byteBuf.capacity(newCapacity);
    }

    @Override
    public int maxCapacity() {
        return byteBuf.maxCapacity();
    }

    @Override
    public ByteBufAllocator alloc() {
        return byteBuf.alloc();
    }

    @Override
    @Deprecated
    public ByteOrder order() {
        return byteBuf.order();
    }

    @Override
    @Deprecated
    public ByteBuf order(ByteOrder endianness) {
        return byteBuf.order(endianness);
    }

    @Override
    public ByteBuf unwrap() {
        return byteBuf.unwrap();
    }

    @Override
    public boolean isDirect() {
        return byteBuf.isDirect();
    }

    @Override
    public boolean isReadOnly() {
        return byteBuf.isReadOnly();
    }

    @Override
    public ByteBuf asReadOnly() {
        return byteBuf.asReadOnly();
    }

    @Override
    public int readerIndex() {
        return byteBuf.readerIndex();
    }

    @Override
    public ByteBuf readerIndex(int readerIndex) {
        return byteBuf.readerIndex(readerIndex);
    }

    @Override
    public int writerIndex() {
        return byteBuf.writerIndex();
    }

    @Override
    public ByteBuf writerIndex(int writerIndex) {
        return byteBuf.writerIndex(writerIndex);
    }

    @Override
    public ByteBuf setIndex(int readerIndex, int writerIndex) {
        return byteBuf.setIndex(readerIndex, writerIndex);
    }

    @Override
    public int readableBytes() {
        return byteBuf.readableBytes();
    }

    @Override
    public int writableBytes() {
        return byteBuf.writableBytes();
    }

    @Override
    public int maxWritableBytes() {
        return byteBuf.maxWritableBytes();
    }

    @Override
    public int maxFastWritableBytes() {
        return byteBuf.maxFastWritableBytes();
    }

    @Override
    public boolean isReadable() {
        return byteBuf.isReadable();
    }

    @Override
    public boolean isReadable(int size) {
        return byteBuf.isReadable(size);
    }

    @Override
    public boolean isWritable() {
        return byteBuf.isWritable();
    }

    @Override
    public boolean isWritable(int size) {
        return byteBuf.isWritable(size);
    }

    @Override
    public ByteBuf clear() {
        return byteBuf.clear();
    }

    @Override
    public ByteBuf markReaderIndex() {
        return byteBuf.markReaderIndex();
    }

    @Override
    public ByteBuf resetReaderIndex() {
        return byteBuf.resetReaderIndex();
    }

    @Override
    public ByteBuf markWriterIndex() {
        return byteBuf.markWriterIndex();
    }

    @Override
    public ByteBuf resetWriterIndex() {
        return byteBuf.resetWriterIndex();
    }

    @Override
    public ByteBuf discardReadBytes() {
        return byteBuf.discardReadBytes();
    }

    @Override
    public ByteBuf discardSomeReadBytes() {
        return byteBuf.discardSomeReadBytes();
    }

    @Override
    public ByteBuf ensureWritable(int minWritableBytes) {
        return byteBuf.ensureWritable(minWritableBytes);
    }

    @Override
    public int ensureWritable(int minWritableBytes, boolean force) {
        return byteBuf.ensureWritable(minWritableBytes, force);
    }

    @Override
    public boolean getBoolean(int index) {
        return byteBuf.getBoolean(index);
    }

    @Override
    public byte getByte(int index) {
        return byteBuf.getByte(index);
    }

    @Override
    public short getUnsignedByte(int index) {
        return byteBuf.getUnsignedByte(index);
    }

    @Override
    public short getShort(int index) {
        return byteBuf.getShort(index);
    }

    @Override
    public short getShortLE(int index) {
        return byteBuf.getShortLE(index);
    }

    @Override
    public int getUnsignedShort(int index) {
        return byteBuf.getUnsignedShort(index);
    }

    @Override
    public int getUnsignedShortLE(int index) {
        return byteBuf.getUnsignedShortLE(index);
    }

    @Override
    public int getMedium(int index) {
        return byteBuf.getMedium(index);
    }

    @Override
    public int getMediumLE(int index) {
        return byteBuf.getMediumLE(index);
    }

    @Override
    public int getUnsignedMedium(int index) {
        return byteBuf.getUnsignedMedium(index);
    }

    @Override
    public int getUnsignedMediumLE(int index) {
        return byteBuf.getUnsignedMediumLE(index);
    }

    @Override
    public int getInt(int index) {
        return byteBuf.getInt(index);
    }

    @Override
    public int getIntLE(int index) {
        return byteBuf.getIntLE(index);
    }

    @Override
    public long getUnsignedInt(int index) {
        return byteBuf.getUnsignedInt(index);
    }

    @Override
    public long getUnsignedIntLE(int index) {
        return byteBuf.getUnsignedIntLE(index);
    }

    @Override
    public long getLong(int index) {
        return byteBuf.getLong(index);
    }

    @Override
    public long getLongLE(int index) {
        return byteBuf.getLongLE(index);
    }

    @Override
    public char getChar(int index) {
        return byteBuf.getChar(index);
    }

    @Override
    public float getFloat(int index) {
        return byteBuf.getFloat(index);
    }

    @Override
    public float getFloatLE(int index) {
        return byteBuf.getFloatLE(index);
    }

    @Override
    public double getDouble(int index) {
        return byteBuf.getDouble(index);
    }

    @Override
    public double getDoubleLE(int index) {
        return byteBuf.getDoubleLE(index);
    }

    @Override
    public ByteBuf getBytes(int index, ByteBuf dst) {
        return byteBuf.getBytes(index, dst);
    }

    @Override
    public ByteBuf getBytes(int index, ByteBuf dst, int length) {
        return byteBuf.getBytes(index, dst, length);
    }

    @Override
    public ByteBuf getBytes(int index, ByteBuf dst, int dstIndex, int length) {
        return byteBuf.getBytes(index, dst, dstIndex, length);
    }

    @Override
    public ByteBuf getBytes(int index, byte[] dst) {
        return byteBuf.getBytes(index, dst);
    }

    @Override
    public ByteBuf getBytes(int index, byte[] dst, int dstIndex, int length) {
        return byteBuf.getBytes(index, dst, dstIndex, length);
    }

    @Override
    public ByteBuf getBytes(int index, ByteBuffer dst) {
        return byteBuf.getBytes(index, dst);
    }

    @Override
    public ByteBuf getBytes(int index, OutputStream out, int length) throws IOException {
        return byteBuf.getBytes(index, out, length);
    }

    @Override
    public int getBytes(int index, GatheringByteChannel out, int length) throws IOException {
        return byteBuf.getBytes(index, out, length);
    }

    @Override
    public int getBytes(int index, FileChannel out, long position, int length) throws IOException {
        return byteBuf.getBytes(index, out, position, length);
    }

    @Override
    public CharSequence getCharSequence(int index, int length, Charset charset) {
        return byteBuf.getCharSequence(index, length, charset);
    }

    @Override
    public ByteBuf setBoolean(int index, boolean value) {
        return byteBuf.setBoolean(index, value);
    }

    @Override
    public ByteBuf setByte(int index, int value) {
        return byteBuf.setByte(index, value);
    }

    @Override
    public ByteBuf setShort(int index, int value) {
        return byteBuf.setShort(index, value);
    }

    @Override
    public ByteBuf setShortLE(int index, int value) {
        return byteBuf.setShortLE(index, value);
    }

    @Override
    public ByteBuf setMedium(int index, int value) {
        return byteBuf.setMedium(index, value);
    }

    @Override
    public ByteBuf setMediumLE(int index, int value) {
        return byteBuf.setMediumLE(index, value);
    }

    @Override
    public ByteBuf setInt(int index, int value) {
        return byteBuf.setInt(index, value);
    }

    @Override
    public ByteBuf setIntLE(int index, int value) {
        return byteBuf.setIntLE(index, value);
    }

    @Override
    public ByteBuf setLong(int index, long value) {
        return byteBuf.setLong(index, value);
    }

    @Override
    public ByteBuf setLongLE(int index, long value) {
        return byteBuf.setLongLE(index, value);
    }

    @Override
    public ByteBuf setChar(int index, int value) {
        return byteBuf.setChar(index, value);
    }

    @Override
    public ByteBuf setFloat(int index, float value) {
        return byteBuf.setFloat(index, value);
    }

    @Override
    public ByteBuf setFloatLE(int index, float value) {
        return byteBuf.setFloatLE(index, value);
    }

    @Override
    public ByteBuf setDouble(int index, double value) {
        return byteBuf.setDouble(index, value);
    }

    @Override
    public ByteBuf setDoubleLE(int index, double value) {
        return byteBuf.setDoubleLE(index, value);
    }

    @Override
    public ByteBuf setBytes(int index, ByteBuf src) {
        return byteBuf.setBytes(index, src);
    }

    @Override
    public ByteBuf setBytes(int index, ByteBuf src, int length) {
        return byteBuf.setBytes(index, src, length);
    }

    @Override
    public ByteBuf setBytes(int index, ByteBuf src, int srcIndex, int length) {
        return byteBuf.setBytes(index, src, srcIndex, length);
    }

    @Override
    public ByteBuf setBytes(int index, byte[] src) {
        return byteBuf.setBytes(index, src);
    }

    @Override
    public ByteBuf setBytes(int index, byte[] src, int srcIndex, int length) {
        return byteBuf.setBytes(index, src, srcIndex, length);
    }

    @Override
    public ByteBuf setBytes(int index, ByteBuffer src) {
        return byteBuf.setBytes(index, src);
    }

    @Override
    public int setBytes(int index, InputStream in, int length) throws IOException {
        return byteBuf.setBytes(index, in, length);
    }

    @Override
    public int setBytes(int index, ScatteringByteChannel in, int length) throws IOException {
        return byteBuf.setBytes(index, in, length);
    }

    @Override
    public int setBytes(int index, FileChannel in, long position, int length) throws IOException {
        return byteBuf.setBytes(index, in, position, length);
    }

    @Override
    public ByteBuf setZero(int index, int length) {
        return byteBuf.setZero(index, length);
    }

    @Override
    public int setCharSequence(int index, CharSequence sequence, Charset charset) {
        return byteBuf.setCharSequence(index, sequence, charset);
    }

    @Override
    public boolean readBoolean() {
        return byteBuf.readBoolean();
    }

    @Override
    public byte readByte() {
        return byteBuf.readByte();
    }

    @Override
    public short readUnsignedByte() {
        return byteBuf.readUnsignedByte();
    }

    @Override
    public short readShort() {
        return byteBuf.readShort();
    }

    @Override
    public short readShortLE() {
        return byteBuf.readShortLE();
    }

    @Override
    public int readUnsignedShort() {
        return byteBuf.readUnsignedShort();
    }

    @Override
    public int readUnsignedShortLE() {
        return byteBuf.readUnsignedShortLE();
    }

    @Override
    public int readMedium() {
        return byteBuf.readMedium();
    }

    @Override
    public int readMediumLE() {
        return byteBuf.readMediumLE();
    }

    @Override
    public int readUnsignedMedium() {
        return byteBuf.readUnsignedMedium();
    }

    @Override
    public int readUnsignedMediumLE() {
        return byteBuf.readUnsignedMediumLE();
    }

    @Override
    public int readInt() {
        return byteBuf.readInt();
    }

    @Override
    public int readIntLE() {
        return byteBuf.readIntLE();
    }

    @Override
    public long readUnsignedInt() {
        return byteBuf.readUnsignedInt();
    }

    @Override
    public long readUnsignedIntLE() {
        return byteBuf.readUnsignedIntLE();
    }

    @Override
    public long readLong() {
        return byteBuf.readLong();
    }

    @Override
    public long readLongLE() {
        return byteBuf.readLongLE();
    }

    @Override
    public char readChar() {
        return byteBuf.readChar();
    }

    @Override
    public float readFloat() {
        return byteBuf.readFloat();
    }

    @Override
    public float readFloatLE() {
        return byteBuf.readFloatLE();
    }

    @Override
    public double readDouble() {
        return byteBuf.readDouble();
    }

    @Override
    public double readDoubleLE() {
        return byteBuf.readDoubleLE();
    }

    @Override
    public ByteBuf readBytes(int length) {
        return byteBuf.readBytes(length);
    }

    @Override
    public ByteBuf readSlice(int length) {
        return byteBuf.readSlice(length);
    }

    @Override
    public ByteBuf readRetainedSlice(int length) {
        return byteBuf.readRetainedSlice(length);
    }

    @Override
    public ByteBuf readBytes(ByteBuf dst) {
        return byteBuf.readBytes(dst);
    }

    @Override
    public ByteBuf readBytes(ByteBuf dst, int length) {
        return byteBuf.readBytes(dst, length);
    }

    @Override
    public ByteBuf readBytes(ByteBuf dst, int dstIndex, int length) {
        return byteBuf.readBytes(dst, dstIndex, length);
    }

    @Override
    public ByteBuf readBytes(byte[] dst) {
        return byteBuf.readBytes(dst);
    }

    @Override
    public ByteBuf readBytes(byte[] dst, int dstIndex, int length) {
        return byteBuf.readBytes(dst, dstIndex, length);
    }

    @Override
    public ByteBuf readBytes(ByteBuffer dst) {
        return byteBuf.readBytes(dst);
    }

    @Override
    public ByteBuf readBytes(OutputStream out, int length) throws IOException {
        return byteBuf.readBytes(out, length);
    }

    @Override
    public int readBytes(GatheringByteChannel out, int length) throws IOException {
        return byteBuf.readBytes(out, length);
    }

    @Override
    public CharSequence readCharSequence(int length, Charset charset) {
        return byteBuf.readCharSequence(length, charset);
    }

    @Override
    public int readBytes(FileChannel out, long position, int length) throws IOException {
        return byteBuf.readBytes(out, position, length);
    }

    @Override
    public ByteBuf skipBytes(int length) {
        return byteBuf.skipBytes(length);
    }

    @Override
    public ByteBuf writeBoolean(boolean value) {
        return byteBuf.writeBoolean(value);
    }

    @Override
    public ByteBuf writeByte(int value) {
        return byteBuf.writeByte(value);
    }

    @Override
    public ByteBuf writeShort(int value) {
        return byteBuf.writeShort(value);
    }

    @Override
    public ByteBuf writeShortLE(int value) {
        return byteBuf.writeShortLE(value);
    }

    @Override
    public ByteBuf writeMedium(int value) {
        return byteBuf.writeMedium(value);
    }

    @Override
    public ByteBuf writeMediumLE(int value) {
        return byteBuf.writeMediumLE(value);
    }

    @Override
    public ByteBuf writeInt(int value) {
        return byteBuf.writeInt(value);
    }

    @Override
    public ByteBuf writeIntLE(int value) {
        return byteBuf.writeIntLE(value);
    }

    @Override
    public ByteBuf writeLong(long value) {
        return byteBuf.writeLong(value);
    }

    @Override
    public ByteBuf writeLongLE(long value) {
        return byteBuf.writeLongLE(value);
    }

    @Override
    public ByteBuf writeChar(int value) {
        return byteBuf.writeChar(value);
    }

    @Override
    public ByteBuf writeFloat(float value) {
        return byteBuf.writeFloat(value);
    }

    @Override
    public ByteBuf writeFloatLE(float value) {
        return byteBuf.writeFloatLE(value);
    }

    @Override
    public ByteBuf writeDouble(double value) {
        return byteBuf.writeDouble(value);
    }

    @Override
    public ByteBuf writeDoubleLE(double value) {
        return byteBuf.writeDoubleLE(value);
    }

    @Override
    public ByteBuf writeBytes(ByteBuf src) {
        return byteBuf.writeBytes(src);
    }

    @Override
    public ByteBuf writeBytes(ByteBuf src, int length) {
        return byteBuf.writeBytes(src, length);
    }

    @Override
    public ByteBuf writeBytes(ByteBuf src, int srcIndex, int length) {
        return byteBuf.writeBytes(src, srcIndex, length);
    }

    @Override
    public ByteBuf writeBytes(byte[] src) {
        return byteBuf.writeBytes(src);
    }

    @Override
    public ByteBuf writeBytes(byte[] src, int srcIndex, int length) {
        return byteBuf.writeBytes(src, srcIndex, length);
    }

    @Override
    public ByteBuf writeBytes(ByteBuffer src) {
        return byteBuf.writeBytes(src);
    }

    @Override
    public int writeBytes(InputStream in, int length) throws IOException {
        return byteBuf.writeBytes(in, length);
    }

    @Override
    public int writeBytes(ScatteringByteChannel in, int length) throws IOException {
        return byteBuf.writeBytes(in, length);
    }

    @Override
    public int writeBytes(FileChannel in, long position, int length) throws IOException {
        return byteBuf.writeBytes(in, position, length);
    }

    @Override
    public ByteBuf writeZero(int length) {
        return byteBuf.writeZero(length);
    }

    @Override
    public int writeCharSequence(CharSequence sequence, Charset charset) {
        return byteBuf.writeCharSequence(sequence, charset);
    }

    @Override
    public int indexOf(int fromIndex, int toIndex, byte value) {
        return byteBuf.indexOf(fromIndex, toIndex, value);
    }

    @Override
    public int bytesBefore(byte value) {
        return byteBuf.bytesBefore(value);
    }

    @Override
    public int bytesBefore(int length, byte value) {
        return byteBuf.bytesBefore(length, value);
    }

    @Override
    public int bytesBefore(int index, int length, byte value) {
        return byteBuf.bytesBefore(index, length, value);
    }

    @Override
    public int forEachByte(ByteProcessor processor) {
        return byteBuf.forEachByte(processor);
    }

    @Override
    public int forEachByte(int index, int length, ByteProcessor processor) {
        return byteBuf.forEachByte(index, length, processor);
    }

    @Override
    public int forEachByteDesc(ByteProcessor processor) {
        return byteBuf.forEachByteDesc(processor);
    }

    @Override
    public int forEachByteDesc(int index, int length, ByteProcessor processor) {
        return byteBuf.forEachByteDesc(index, length, processor);
    }

    @Override
    public ByteBuf copy() {
        return byteBuf.copy();
    }

    @Override
    public ByteBuf copy(int index, int length) {
        return byteBuf.copy(index, length);
    }

    @Override
    public ByteBuf slice() {
        return byteBuf.slice();
    }

    @Override
    public ByteBuf retainedSlice() {
        return byteBuf.retainedSlice();
    }

    @Override
    public ByteBuf slice(int index, int length) {
        return byteBuf.slice(index, length);
    }

    @Override
    public ByteBuf retainedSlice(int index, int length) {
        return byteBuf.retainedSlice(index, length);
    }

    @Override
    public ByteBuf duplicate() {
        return byteBuf.duplicate();
    }

    @Override
    public ByteBuf retainedDuplicate() {
        return byteBuf.retainedDuplicate();
    }

    @Override
    public int nioBufferCount() {
        return byteBuf.nioBufferCount();
    }

    @Override
    public ByteBuffer nioBuffer() {
        return byteBuf.nioBuffer();
    }

    @Override
    public ByteBuffer nioBuffer(int index, int length) {
        return byteBuf.nioBuffer(index, length);
    }

    @Override
    public ByteBuffer internalNioBuffer(int index, int length) {
        return byteBuf.internalNioBuffer(index, length);
    }

    @Override
    public ByteBuffer[] nioBuffers() {
        return byteBuf.nioBuffers();
    }

    @Override
    public ByteBuffer[] nioBuffers(int index, int length) {
        return byteBuf.nioBuffers(index, length);
    }

    @Override
    public boolean hasArray() {
        return byteBuf.hasArray();
    }

    @Override
    public byte[] array() {
        return byteBuf.array();
    }

    @Override
    public int arrayOffset() {
        return byteBuf.arrayOffset();
    }

    @Override
    public boolean hasMemoryAddress() {
        return byteBuf.hasMemoryAddress();
    }

    @Override
    public long memoryAddress() {
        return byteBuf.memoryAddress();
    }

    @Override
    public boolean isContiguous() {
        return byteBuf.isContiguous();
    }

    @Override
    public String toString(Charset charset) {
        return byteBuf.toString(charset);
    }

    @Override
    public String toString(int index, int length, Charset charset) {
        return byteBuf.toString(index, length, charset);
    }

    @Override
    public int hashCode() {
        return byteBuf.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return byteBuf.equals(obj);
    }

    @Override
    public int compareTo(ByteBuf buffer) {
        return byteBuf.compareTo(buffer);
    }

    @Override
    public String toString() {
        return byteBuf.toString();
    }

    @Override
    public ByteBuf retain(int increment) {
        return byteBuf.retain(increment);
    }

    @Override
    public ByteBuf retain() {
        return byteBuf.retain();
    }

    @Override
    public ByteBuf touch() {
        return byteBuf.touch();
    }

    @Override
    public ByteBuf touch(Object hint) {
        return byteBuf.touch(hint);
    }

    @Override
    public int refCnt() {
        return byteBuf.refCnt();
    }

    @Override
    public boolean release() {
        return byteBuf.release();
    }

    @Override
    public boolean release(int decrement) {
        return byteBuf.release(decrement);
    }
}

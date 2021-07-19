package eu.mshade.enderframe.protocol.temp;

import eu.mshade.enderframe.protocol.packet.PacketOutDisconnect;
import eu.mshade.enderframe.protocol.temp.listener.PacketHandshakeListener;
import eu.mshade.enderframe.protocol.temp.listener.PacketPingListener;
import eu.mshade.enderframe.protocol.temp.listener.PacketStatusListener;
import eu.mshade.enderframe.protocol.temp.packet.*;
import eu.mshade.enderframe.EnderFrameProtocol;
import eu.mshade.enderframe.EnderFrameSession;
import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.ProtocolStatus;
import eu.mshade.enderframe.protocol.ProtocolVersion;
import io.netty.buffer.ByteBuf;

public class TempEnderFrameProtocol extends EnderFrameProtocol {


    public TempEnderFrameProtocol() {

        this.getEventBus().subscribe(PacketInHandshake.class, new PacketHandshakeListener());
        this.getEventBus().subscribe(PacketInStatus.class, new PacketStatusListener());
        this.getEventBus().subscribe(PacketInPing.class, new PacketPingListener());

        this.getProtocolRegistry().registerIn(ProtocolStatus.HANDSHAKE, 0x00, PacketInHandshake.class);

        this.getProtocolRegistry().registerOut(ProtocolStatus.STATUS, 0x00, PacketOutStatus.class);
        this.getProtocolRegistry().registerOut(ProtocolStatus.STATUS, 0x01, PacketOutPong.class);
        this.getProtocolRegistry().registerIn(ProtocolStatus.STATUS, 0x00, PacketInStatus.class);
        this.getProtocolRegistry().registerIn(ProtocolStatus.STATUS, 0x01, PacketInPing.class);

        this.getProtocolRegistry().registerOut(ProtocolStatus.LOGIN, 0x00, PacketOutDisconnect.class);
    }

    @Override
    public ByteMessage getByteMessage(ByteBuf byteBuf) {
        return new TempByteMessage(byteBuf);
    }

    @Override
    public ProtocolVersion getProtocolVersion() {
        return ProtocolVersion.UNKNOWN;
    }

    @Override
    public EnderFrameSession getEnderFrameSession(EnderFrameSessionHandler enderFrameSessionHandler) {
        return null;
    }


}

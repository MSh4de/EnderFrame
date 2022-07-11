package eu.mshade.enderframe.protocol.temp;

import eu.mshade.enderframe.protocol.*;
import eu.mshade.enderframe.protocol.packet.PacketOutDisconnect;
import eu.mshade.enderframe.protocol.temp.listener.PacketHandshakeListener;
import eu.mshade.enderframe.protocol.temp.listener.PacketPingListener;
import eu.mshade.enderframe.protocol.temp.listener.PacketStatusListener;
import eu.mshade.enderframe.protocol.temp.packet.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;


public class TempProtocol extends Protocol {

    private static TempProtocol INSTANCE;
    public TempProtocol() {
        INSTANCE = this;

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
    public ProtocolBuffer getProtocolBuffer(ByteBuf byteBuf) {
        return new TempProtocolBuffer(byteBuf);
    }

    @Override
    public SessionWrapper getSessionWrapper(Channel channel) {
        return new TempSessionWrapper(channel);
    }

    @Override
    public MinecraftProtocolVersion getMinecraftProtocolVersion() {
        return MinecraftProtocolVersion.UNKNOWN;
    }


    public static TempProtocol getInstance(){
        return (INSTANCE != null ? INSTANCE : new TempProtocol());
    }

}

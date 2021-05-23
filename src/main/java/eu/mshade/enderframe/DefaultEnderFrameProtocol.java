package eu.mshade.enderframe;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.listener.PacketHandshakeListener;
import eu.mshade.enderframe.listener.PacketPingListener;
import eu.mshade.enderframe.listener.PacketStatusListener;
import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.ProtocolFrame;
import eu.mshade.enderframe.protocol.ProtocolStatus;
import eu.mshade.enderframe.protocol.ProtocolVersion;
import eu.mshade.enderframe.protocol.packet.*;
import io.netty.buffer.ByteBuf;

public class DefaultProtocolFrame extends ProtocolFrame {


    public DefaultProtocolFrame() {

        getDispatcherDriver().register(PacketInHandshake.class, new PacketHandshakeListener());
        getDispatcherDriver().register(PacketInStatus.class, new PacketStatusListener());
        getDispatcherDriver().register(PacketInPing.class, new PacketPingListener());

        getProtocolRegistry().registerIn(ProtocolStatus.HANDSHAKE, 0x00, PacketInHandshake.class);

        getProtocolRegistry().registerOut(ProtocolStatus.STATUS, 0x00, PacketOutStatus.class);
        getProtocolRegistry().registerOut(ProtocolStatus.STATUS, 0x01, PacketOutPong.class);
        getProtocolRegistry().registerIn(ProtocolStatus.STATUS, 0x00, PacketInStatus.class);
        getProtocolRegistry().registerIn(ProtocolStatus.STATUS, 0x01, PacketInPing.class);
    }

    @Override
    public ByteMessage getByteMessage(ByteBuf byteBuf) {
        return new DefaultByteMessage(byteBuf);
    }

    @Override
    public ProtocolVersion getProtocolVersion() {
        return ProtocolVersion.UNKNOWN;
    }

    @Override
    public Player getPlayer(String name, EnderFrameSessionHandler enderFrameSessionHandler) {
        return null;
    }


}

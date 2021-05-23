package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.EnderFrameSession;
import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.mwork.dispatcher.DefaultDispatcherDriver;
import eu.mshade.mwork.dispatcher.DispatcherDriver;
import io.netty.buffer.ByteBuf;

public abstract class EnderFrameProtocol {

    private final ProtocolRegistry protocolRegistry = new ProtocolRegistry();
    private final DispatcherDriver<PacketIn> packetInDispatcherDriver = new DefaultDispatcherDriver<>();

    public abstract ByteMessage getByteMessage(ByteBuf byteBuf);

    public ProtocolRegistry getProtocolRegistry(){
        return protocolRegistry;
    }

    public abstract ProtocolVersion getProtocolVersion();

    public DispatcherDriver<PacketIn> getDispatcherDriver(){
        return packetInDispatcherDriver;
    };

    public abstract EnderFrameSession getEnderFrameSession(EnderFrameSessionHandler enderFrameSessionHandler);

}

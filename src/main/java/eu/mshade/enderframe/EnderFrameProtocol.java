package eu.mshade.enderframe;

import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketIn;
import eu.mshade.enderframe.protocol.ProtocolRegistry;
import eu.mshade.enderframe.protocol.ProtocolVersion;
import eu.mshade.mwork.event.EventBus;
import io.netty.buffer.ByteBuf;

public abstract class EnderFrameProtocol {

    private final ProtocolRegistry protocolRegistry = new ProtocolRegistry();
    private final EventBus<PacketIn> eventBus = new EventBus<>();

    public abstract ByteMessage getByteMessage(ByteBuf byteBuf);

    public ProtocolRegistry getProtocolRegistry(){
        return protocolRegistry;
    }

    public abstract ProtocolVersion getProtocolVersion();

    public EventBus<PacketIn> getEventBus(){
        return eventBus;
    };

    public abstract EnderFrameSession getEnderFrameSession(EnderFrameSessionHandler enderFrameSessionHandler);

}

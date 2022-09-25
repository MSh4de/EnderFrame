package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.wrapper.WrapperRepository;
import eu.mshade.mwork.event.EventBus;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

public abstract class Protocol {

    protected final ProtocolRegistry protocolRegistry = new ProtocolRegistry();
    protected final EventBus<PacketIn> eventBus = new EventBus<>();
    protected final WrapperRepository wrapperRepository = new WrapperRepository();

    public abstract ProtocolBuffer getProtocolBuffer(ByteBuf byteBuf);

    public abstract SessionWrapper getSessionWrapper(Channel channel);

    public ProtocolRegistry getProtocolRegistry(){
        return protocolRegistry;
    }

    public abstract MinecraftProtocolVersion getMinecraftProtocolVersion();

    public EventBus<PacketIn> getEventBus(){
        return eventBus;
    };

    public WrapperRepository getWrapperRepository(){
        return wrapperRepository;
    }

}

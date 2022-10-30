package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.entity.EntityRepository;
import eu.mshade.enderframe.wrapper.Wrapper;
import eu.mshade.mwork.event.EventBus;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

public abstract class Protocol {

    protected final EntityRepository entityRepository = new EntityRepository();
    protected final ProtocolRegistry protocolRegistry = new ProtocolRegistry();
    protected final EventBus<PacketIn> eventBus = new EventBus<>();

    public abstract ProtocolBuffer getProtocolBuffer(ByteBuf byteBuf);

    public abstract SessionWrapper getSessionWrapper(Channel channel);

    public ProtocolRegistry getProtocolRegistry(){
        return protocolRegistry;
    }

    public EntityRepository getEntityRepository() { return entityRepository; }

    public abstract MinecraftProtocolVersion getMinecraftProtocolVersion();

    public EventBus<PacketIn> getEventBus(){
        return eventBus;
    };

}

package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.entity.EntityMapper;
import eu.mshade.enderframe.world.block.BlockTransformerRepository;
import eu.mshade.enderframe.wrapper.WrapperRepository;
import eu.mshade.mwork.event.EventBus;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

public abstract class Protocol {

    protected final ProtocolRegistry protocolRegistry = new ProtocolRegistry();
    protected final EventBus<PacketIn> eventBus = new EventBus<>();
    protected final WrapperRepository wrapperRepository = new WrapperRepository();
    protected final BlockTransformerRepository blockTransformerRepository = new BlockTransformerRepository();

    public abstract ProtocolBuffer getProtocolBuffer(ByteBuf byteBuf);

    public abstract SessionWrapper getSessionWrapper(Channel channel);

    public abstract EntityMapper getEntityMapper();

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

    public BlockTransformerRepository getBlockTransformerRepository(){
        return blockTransformerRepository;
    }

}

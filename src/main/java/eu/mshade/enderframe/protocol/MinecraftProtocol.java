package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.entity.EntityMapper;
import eu.mshade.enderframe.world.block.BlockTransformerController;
import eu.mshade.enderframe.wrapper.WrapperRepository;
import eu.mshade.mwork.event.EventBus;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

public abstract class MinecraftProtocol {

    protected final MinecraftPacketRegistry minecraftPacketRegistry = new MinecraftPacketRegistry();
    protected final EventBus<MinecraftPacketIn> eventBus = new EventBus<>();
    protected final WrapperRepository wrapperRepository = new WrapperRepository();

    public abstract MinecraftByteBuf getProtocolBuffer(ByteBuf byteBuf);

    public abstract MinecraftSession getMinecraftSession(Channel channel);

    public MinecraftPacketRegistry getProtocolRegistry(){
        return minecraftPacketRegistry;
    }

    public abstract MinecraftProtocolVersion getMinecraftProtocolVersion();

    public EventBus<MinecraftPacketIn> getEventBus(){
        return eventBus;
    };

    public WrapperRepository getWrapperRepository(){
        return wrapperRepository;
    }

    public abstract BlockTransformerController getBlockTransformerController();

    public abstract EntityMapper getEntityMapper();



}

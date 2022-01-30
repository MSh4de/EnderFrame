package eu.mshade.enderframe;

import eu.mshade.enderframe.entity.EntityRepository;
import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketIn;
import eu.mshade.enderframe.protocol.ProtocolRegistry;
import eu.mshade.enderframe.protocol.ProtocolVersion;
import eu.mshade.mwork.event.EventBus;
import io.netty.buffer.ByteBuf;

import java.util.concurrent.ScheduledExecutorService;

public abstract class EnderFrameProtocol {

    private final EntityRepository entityRepository = new EntityRepository();
    private final ProtocolRegistry protocolRegistry = new ProtocolRegistry();
    private final EventBus<PacketIn> eventBus = new EventBus<>();

    public abstract ByteMessage getByteMessage(ByteBuf byteBuf);

    public ProtocolRegistry getProtocolRegistry(){
        return protocolRegistry;
    }

    public EntityRepository getEntityRepository() { return entityRepository; }

    public abstract ProtocolVersion getProtocolVersion();

    public EventBus<PacketIn> getEventBus(){
        return eventBus;
    };

    public abstract EnderFrameSession getEnderFrameSession(EnderFrameSessionHandler enderFrameSessionHandler);

}

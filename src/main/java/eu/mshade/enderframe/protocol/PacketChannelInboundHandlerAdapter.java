package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.event.PlayerQuitEvent;
import eu.mshade.mwork.ParameterContainer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class PacketChannelInboundHandlerAdapter extends ChannelInboundHandlerAdapter {

    private final Channel channel;

    public PacketChannelInboundHandlerAdapter(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof PacketIn packetIn){
            ProtocolPipeline protocolPipeline = ProtocolPipeline.get();
            protocolPipeline.getProtocol(channel).getEventBus().publish(packetIn);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        ProtocolPipeline protocolPipeline = ProtocolPipeline.get();
        if (protocolPipeline.getPlayer(channel) != null) {
            EnderFrame.get().getEnderFrameEventBus().publish(new PlayerQuitEvent(protocolPipeline.getSessionWrapper(channel)));
        }
        protocolPipeline.flush(channel);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
    }
}

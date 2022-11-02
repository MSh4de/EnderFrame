package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.event.PlayerQuitEvent;
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
        if (msg instanceof MinecraftPacketIn minecraftPacketIn){
            ProtocolPipeline protocolPipeline = ProtocolPipeline.get();
            protocolPipeline.getProtocol(channel).getEventBus().publish(minecraftPacketIn);
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

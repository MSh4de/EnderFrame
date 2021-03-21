package eu.mshadeproduction.enderframe;

import eu.mshadeproduction.enderframe.protocol.*;
import eu.mshadeproduction.mwork.dispatcher.DispatcherContainerBuilder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EnderFrameBridge extends ChannelInboundHandlerAdapter {

    private final Channel channel;
    private ProtocolFrame protocolFrame = new DefaultProtocolFrame();
    private ProtocolStatus protocolStatus = ProtocolStatus.HANDSHAKE;

    public EnderFrameBridge(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof PacketIn) protocolFrame.getDispatcherDriver().dispatch((PacketIn) msg, DispatcherContainerBuilder.builder().setContainer(this).build());
    }


    public void sendPacket(PacketOut packet) {
        if (isConnected())
            channel.writeAndFlush(packet, channel.voidPromise());
    }

    public void sendPacketAndClose(PacketOut packet) {
        if (isConnected())
            channel.writeAndFlush(packet).addListener(ChannelFutureListener.CLOSE);
    }

    public void toggleProtocolFrame(ProtocolFrame protocolFrame){
        this.protocolFrame = protocolFrame;
        channel.pipeline().get(PacketEncoder.class).toggleProtocolFrame(protocolFrame);
        channel.pipeline().get(PacketDecoder.class).toggleProtocolFrame(protocolFrame);
    }

    public ProtocolFrame getProtocolFrame() { return protocolFrame; }

    public void toggleProtocolStatus(ProtocolStatus protocolStatus){
        this.protocolStatus = protocolStatus;
        channel.pipeline().get(PacketEncoder.class).toggleProtocolStatus(protocolStatus);
        channel.pipeline().get(PacketDecoder.class).toggleProtocolStatus(protocolStatus);
    }

    public ProtocolStatus getProtocolStatus() { return protocolStatus; }

    public boolean isConnected() {
        return channel.isActive();
    }
}

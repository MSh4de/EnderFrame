package eu.mshade.enderframe;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.protocol.*;
import eu.mshade.mwork.dispatcher.DispatcherContainer;
import eu.mshade.mwork.dispatcher.DispatcherContainerBuilder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EnderFrameSession extends ChannelInboundHandlerAdapter {

    private final Channel channel;
    private ProtocolFrame protocolFrame = new DefaultProtocolFrame();
    private ProtocolStatus protocolStatus = ProtocolStatus.HANDSHAKE;
    private Player player;
    private final DispatcherContainer dispatcherContainer = DispatcherContainerBuilder.builder().setContainer(this).build();

    public EnderFrameSession(Channel channel) {
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
        if (msg instanceof PacketIn) protocolFrame.getDispatcherDriver().dispatch((PacketIn) msg, dispatcherContainer);
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

    public void toggleCompressor(int value){
        this.channel.flush();
        this.channel.pipeline().addBefore("decoder", "decompress", new PacketDecompress(value));
        this.channel.pipeline().addBefore("encoder", "compress", new PacketCompress(value));
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ProtocolStatus getProtocolStatus() { return protocolStatus; }

    public boolean isConnected() {
        return channel.isActive();
    }
}

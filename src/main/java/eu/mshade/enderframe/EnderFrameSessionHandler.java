package eu.mshade.enderframe;

import eu.mshade.enderframe.packetevent.PacketQuitEvent;
import eu.mshade.enderframe.protocol.*;
import eu.mshade.enderframe.protocol.temp.TempEnderFrameProtocol;
import eu.mshade.mwork.ParameterContainer;
import io.netty.channel.*;

import javax.crypto.SecretKey;

public class EnderFrameSessionHandler extends ChannelInboundHandlerAdapter {

    private final Channel channel;
    private EnderFrameProtocol enderFrameProtocol = new TempEnderFrameProtocol();
    private ProtocolStatus protocolStatus = ProtocolStatus.HANDSHAKE;
    private ProtocolVersion protocolVersion = ProtocolVersion.UNKNOWN;
    private EnderFrameSession enderFrameSession;
    private Handshake handshake;
    private final ParameterContainer eventContainer = ParameterContainer.of()
            .putContainer(this);

    public EnderFrameSessionHandler(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        if (protocolStatus == ProtocolStatus.PLAY) {
            EnderFrame.get().getPacketEventBus().publish(new PacketQuitEvent(enderFrameSession));
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof PacketIn) enderFrameProtocol.getEventBus().publish((PacketIn) msg, eventContainer);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    public void sendPacket(PacketOut packet) {
        if (isConnected())
            channel.writeAndFlush(packet, channel.voidPromise());
    }

    public void sendPacketAndClose(PacketOut packet) {
        if (isConnected())
            channel.writeAndFlush(packet).addListener(ChannelFutureListener.CLOSE);
    }

    public void toggleEnderFrameProtocol(EnderFrameProtocol enderFrameProtocol){
        this.enderFrameProtocol = enderFrameProtocol;
        this.channel.flush();
        channel.pipeline().get(PacketCodec.class).toggleProtocolFrame(enderFrameProtocol);
    }

    public EnderFrameProtocol getEnderFrameProtocol() { return enderFrameProtocol; }

    public void toggleProtocolStatus(ProtocolStatus protocolStatus){
        this.protocolStatus = protocolStatus;
        channel.pipeline().get(PacketCodec.class).toggleProtocolStatus(protocolStatus);
    }

    public void enableEncryption(SecretKey sharedSecret) {
        updatePipeline("encryption", new PacketEncryption(sharedSecret));
    }

    public void enableCompression(int threshold){
        updatePipeline("compression", new PacketCompression(threshold));
    }

    private void updatePipeline(String key, ChannelHandler handler) {
        this.channel.pipeline().replace(key, key, handler);
    }

    public EnderFrameSession getEnderFrameSession() {
        return enderFrameSession;
    }

    public void setEnderFrameSession(EnderFrameSession enderFrameSession) {
        this.enderFrameSession = enderFrameSession;
    }

    public Channel getChannel() {
        return channel;
    }

    public ProtocolStatus getProtocolStatus() { return protocolStatus; }

    public ProtocolVersion getProtocolVersion() {
        return protocolVersion;
    }

    public EnderFrameSessionHandler setProtocolVersion(ProtocolVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
        return this;
    }

    public Handshake getHandshake() {
        return handshake;
    }

    public EnderFrameSessionHandler setHandshake(Handshake handshake) {
        this.handshake = handshake;
        return this;
    }

    public boolean isConnected() {
        return channel.isActive();
    }
}

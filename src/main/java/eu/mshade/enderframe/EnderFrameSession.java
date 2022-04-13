package eu.mshade.enderframe;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.mojang.GameProfile;
import eu.mshade.enderframe.packetevent.PacketQuitEvent;
import eu.mshade.enderframe.protocol.*;
import eu.mshade.enderframe.protocol.temp.TempEnderFrameProtocol;
import eu.mshade.mwork.ParameterContainer;
import io.netty.channel.*;

import javax.crypto.SecretKey;
import java.net.SocketAddress;
import java.util.Random;

public class EnderFrameSession extends ChannelInboundHandlerAdapter {

    private static final Random random = new Random();

    private final Channel channel;
    private final String sessionId;
    private final byte[] verifyToken = new byte[4];
    private GameProfile gameProfile;
    private SocketAddress socketAddress;
    private EnderFrameProtocol enderFrameProtocol = TempEnderFrameProtocol.getInstance();
    private ProtocolStatus protocolStatus = ProtocolStatus.HANDSHAKE;
    private MinecraftProtocolVersion minecraftProtocolVersion = MinecraftProtocolVersion.UNKNOWN;
    private Player player;
    private Handshake handshake;
    private final ParameterContainer eventContainer = ParameterContainer.of()
            .putContainer(this);

    public EnderFrameSession(Channel channel) {
        this.channel = channel;
        this.sessionId = Long.toString(random.nextLong(), 16).trim();
        this.socketAddress = channel.remoteAddress();
        random.nextBytes(verifyToken);
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

    public GameProfile getGameProfile() {
        return gameProfile;
    }

    public void setGameProfile(GameProfile gameProfile) {
        this.gameProfile = gameProfile;
    }

    public SocketAddress getSocketAddress() {
        return socketAddress;
    }

    public void setSocketAddress(SocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }

    public String getSessionId() {
        return sessionId;
    }

    public byte[] getVerifyToken() {
        return verifyToken;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void sendPacket(PacketOut packet) {
        if (isConnected())
            channel.writeAndFlush(packet);
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


    public Channel getChannel() {
        return channel;
    }

    public ProtocolStatus getProtocolStatus() { return protocolStatus; }

    public MinecraftProtocolVersion getProtocolVersion() {
        return minecraftProtocolVersion;
    }

    public EnderFrameSession setProtocolVersion(MinecraftProtocolVersion minecraftProtocolVersion) {
        this.minecraftProtocolVersion = minecraftProtocolVersion;
        return this;
    }

    public Handshake getHandshake() {
        return handshake;
    }

    public EnderFrameSession setHandshake(Handshake handshake) {
        this.handshake = handshake;
        return this;
    }

    public boolean isConnected() {
        return channel.isActive();
    }
}

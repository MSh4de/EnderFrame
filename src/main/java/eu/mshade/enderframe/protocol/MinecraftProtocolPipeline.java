package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.entity.Player;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MinecraftProtocolPipeline {

    private final Map<Channel, MinecraftSession> minecraftSessionByChannel = new ConcurrentHashMap<>();
    private final Map<Channel, Player> playerByChannel = new ConcurrentHashMap<>();
    private final Map<Channel, MinecraftProtocol> protocolByChannel = new ConcurrentHashMap<>();

    private static MinecraftProtocolPipeline minecraftProtocolPipeline;

    private MinecraftProtocolPipeline() {
        minecraftProtocolPipeline = this;
    }

    public MinecraftSession getMinecraftSession(Channel channel){
        return this.minecraftSessionByChannel.get(channel);
    }

    public void setMinecraftSession(Channel channel, MinecraftSession minecraftSession){
        this.minecraftSessionByChannel.put(channel, minecraftSession);
    }

    public Player getPlayer(Channel channel){
        return this.playerByChannel.get(channel);
    }

    public void setPlayer(Channel channel, Player player){
        this.playerByChannel.put(channel, player);
    }

    public MinecraftProtocol getProtocol(Channel channel){
        return this.protocolByChannel.get(channel);
    }

    public void setProtocol(Channel channel, MinecraftProtocol minecraftProtocol){
        this.protocolByChannel.put(channel, minecraftProtocol);
    }

    public void flush(Channel channel){
        this.minecraftSessionByChannel.remove(channel);
        this.playerByChannel.remove(channel);
        this.protocolByChannel.remove(channel);
    }

    public static MinecraftProtocolPipeline get(){
        return (minecraftProtocolPipeline == null ? new MinecraftProtocolPipeline() : minecraftProtocolPipeline);
    }

}

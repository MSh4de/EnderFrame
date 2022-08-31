package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.entity.Player;
import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProtocolPipeline {

    private final Map<Channel, SessionWrapper> sessionWrapperByChannel = new ConcurrentHashMap<>();
    private final Map<Channel, Player> playerByChannel = new ConcurrentHashMap<>();
    private final Map<Channel, Protocol> protocolByChannel = new ConcurrentHashMap<>();

    private static ProtocolPipeline protocolPipeline;

    private ProtocolPipeline() {
        protocolPipeline = this;
    }

    public SessionWrapper getSessionWrapper(Channel channel){
        return this.sessionWrapperByChannel.get(channel);
    }

    public void setSessionWrapper(Channel channel, SessionWrapper sessionWrapper){
        this.sessionWrapperByChannel.put(channel, sessionWrapper);
    }

    public Player getPlayer(Channel channel){
        return this.playerByChannel.get(channel);
    }

    public void setPlayer(Channel channel, Player player){
        this.playerByChannel.put(channel, player);
    }

    public Protocol getProtocol(Channel channel){
        return this.protocolByChannel.get(channel);
    }

    public void setProtocol(Channel channel, Protocol protocol){
        this.protocolByChannel.put(channel, protocol);
    }

    public void flush(Channel channel){
        this.sessionWrapperByChannel.remove(channel);
        this.playerByChannel.remove(channel);
        this.protocolByChannel.remove(channel);
    }

    public static ProtocolPipeline get(){
        return (protocolPipeline == null ? new ProtocolPipeline() : protocolPipeline);
    }

}

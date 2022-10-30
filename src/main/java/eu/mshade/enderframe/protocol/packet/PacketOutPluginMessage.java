package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.PacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

import java.util.function.Consumer;

public class PacketOutPluginMessage implements PacketOut {

    private String channel;
    private Consumer<ProtocolBuffer> payload;

    public PacketOutPluginMessage(String channel, Consumer<ProtocolBuffer> payload) {
        this.channel = channel;
        this.payload = payload;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeString(channel);
        payload.accept(protocolBuffer);
    }
}

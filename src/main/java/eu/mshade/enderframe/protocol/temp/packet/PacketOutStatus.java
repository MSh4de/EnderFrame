package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.ServerListBuilder;
import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketOut;

public class PacketOutStatus extends PacketOut {

    private final ServerListBuilder serverListBuilder;

    public PacketOutStatus(ServerListBuilder serverListBuilder) {
        this.serverListBuilder = serverListBuilder;
    }

    @Override
    public void serialize(ByteMessage byteMessage) {
        byteMessage.writeString(serverListBuilder.build());
    }
}

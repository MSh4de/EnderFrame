package eu.mshadeproduction.enderframe.protocol;

import eu.mshadeproduction.mwork.dispatcher.DispatcherDriver;
import io.netty.buffer.ByteBuf;

public abstract class ProtocolFrame {

    public abstract ByteMessage getByteMessage(ByteBuf byteBuf);

    public abstract ProtocolRegistry getProtocolRegistry();

    public abstract DispatcherDriver<PacketIn> getDispatcherDriver();

}

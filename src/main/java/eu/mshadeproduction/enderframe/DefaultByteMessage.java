package eu.mshadeproduction.enderframe;

import eu.mshadeproduction.enderframe.protocol.ByteMessage;
import io.netty.buffer.ByteBuf;

public class DefaultByteMessage extends ByteMessage {

    public DefaultByteMessage(ByteBuf buf) {
        super(buf);
    }
}

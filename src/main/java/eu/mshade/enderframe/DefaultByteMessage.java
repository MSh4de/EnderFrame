package eu.mshade.enderframe;

import eu.mshade.enderframe.protocol.ByteMessage;
import io.netty.buffer.ByteBuf;

public class DefaultByteMessage extends ByteMessage {

    public DefaultByteMessage(ByteBuf buf) {
        super(buf);
    }
}

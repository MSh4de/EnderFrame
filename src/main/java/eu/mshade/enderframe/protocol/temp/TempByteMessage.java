package eu.mshade.enderframe.protocol.temp;

import eu.mshade.enderframe.protocol.ByteMessage;
import io.netty.buffer.ByteBuf;

public class TempByteMessage extends ByteMessage {

    public TempByteMessage(ByteBuf buf) {
        super(buf);
    }
}

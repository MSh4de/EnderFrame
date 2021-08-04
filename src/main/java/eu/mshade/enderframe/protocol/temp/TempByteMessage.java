package eu.mshade.enderframe.protocol.temp;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.EntityType;
import eu.mshade.enderframe.metadata.MetadataEntry;
import eu.mshade.enderframe.metadata.MetadataMeaning;
import eu.mshade.enderframe.protocol.ByteMessage;
import io.netty.buffer.ByteBuf;

public class TempByteMessage extends ByteMessage {

    public TempByteMessage(ByteBuf buf) {
        super(buf);
    }

    @Override
    public void writeMetadata(Entity entity, MetadataMeaning metadataMeaning) {

    }


}

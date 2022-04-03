package eu.mshade.enderframe.protocol.temp;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.metadata.EntityMetadataType;
import eu.mshade.enderframe.protocol.ByteMessage;
import io.netty.buffer.ByteBuf;

public class TempByteMessage extends ByteMessage {

    public TempByteMessage(ByteBuf buf) {
        super(buf);
    }

    @Override
    public void writeEntityMetadata(Entity entity, EntityMetadataType entityMetadataType) {

    }

    @Override
    public void writeItemStack(ItemStack itemStack) {

    }

    @Override
    public ItemStack readItemStack() {
        return null;
    }


}

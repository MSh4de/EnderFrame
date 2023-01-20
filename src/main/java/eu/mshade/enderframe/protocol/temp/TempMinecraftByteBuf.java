package eu.mshade.enderframe.protocol.temp;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.metadata.EntityMetadataKey;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.protocol.MinecraftByteBuf;
import io.netty.buffer.ByteBuf;

import java.util.Collection;

public class TempMinecraftByteBuf extends MinecraftByteBuf {



    public TempMinecraftByteBuf(ByteBuf byteBuf) {
        super(byteBuf);
    }

    @Override
    public void writeItemStack(ItemStack itemStack) {

    }

    @Override
    public ItemStack readItemStack() {
        return null;
    }

    @Override
    public void writeEntityMetadata(Entity entity, MetadataKey... entityMetadataKey) {

    }

    @Override
    public Collection<MetadataKey> getSupportedMetadataKeys(Entity entity) {
        return null;
    }
}

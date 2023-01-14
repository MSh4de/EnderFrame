package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.protocol.MinecraftByteBuf;

@FunctionalInterface
public interface MetadataBuffer<T extends Metadata<?>> {

    void write(MinecraftByteBuf minecraftByteBuf, T t);

}

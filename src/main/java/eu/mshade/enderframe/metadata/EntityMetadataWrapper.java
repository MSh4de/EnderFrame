package eu.mshade.enderframe.metadata;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.protocol.ByteMessage;

public interface EntityMetadataWrapper<T extends Entity> {

    Metadata<?> wrap(T t);

}

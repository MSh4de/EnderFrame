package eu.mshade.enderframe.metadata.buffer;

import eu.mshade.enderframe.metadata.MetadataEntry;
import eu.mshade.enderframe.metadata.MetadataManager;
import eu.mshade.enderframe.metadata.MetadataMeaning;
import eu.mshade.enderframe.metadata.MetadataType;
import eu.mshade.enderframe.protocol.ByteMessage;

public class EntityMetadataBuffer extends MetadataBuffer {

    public EntityMetadataBuffer() {
        this.getMetadataRepository().registerMetadataIndex(0, MetadataType.BYTE, MetadataMeaning.ENTITY_PROPERTIES);
        this.getMetadataRepository().registerMetadataIndex(1, MetadataType.VAR_INT, MetadataMeaning.AIR_TICKS);
        this.getMetadataRepository().registerMetadataIndex(2, MetadataType.OPT_CHAT, MetadataMeaning.CUSTOM_NAME);
        this.getMetadataRepository().registerMetadataIndex(3, MetadataType.BOOLEAN, MetadataMeaning.IS_CUSTOM_NAME_VISIBLE);
        this.getMetadataRepository().registerMetadataIndex(4, MetadataType.BOOLEAN, MetadataMeaning.IS_SILENT);
        this.getMetadataRepository().registerMetadataIndex(5, MetadataType.BOOLEAN, MetadataMeaning.HAS_NO_GRAVITY);
        this.getMetadataRepository().registerMetadataIndex(6, MetadataType.POSE, MetadataMeaning.POSE);
        this.getMetadataRepository().registerMetadataIndex(7, MetadataType.VAR_INT, MetadataMeaning.TICKS_FROZEN_IN_POWDERED_SNOW);
    }

    @Override
    public void write(ByteMessage byteMessage, MetadataManager metadataManager, MetadataEntry metadataEntry) {
        /*
        byteMessage.writeByte(this.getMetadataRepository().getMetadataIndex(metadataEntry.getMetadataMeaning()));
        byteMessage.writeVarInt(this.getMetadataRepository().getMetadataType(metadataEntry.getMetadataMeaning()).getId());

        */
        int i = (metadataManager.getMetadataTypeRepository().getMetadataIndex(metadataEntry.getMetadata().getMetadataType()) << 5 | this.getMetadataRepository().getMetadataIndex(metadataEntry.getMetadataMeaning()) & 31) & 255;
        byteMessage.writeByte(i);
        metadataManager.getMetadataTypeBuffer(metadataEntry.getMetadata().getMetadataType()).write(byteMessage, metadataEntry.getMetadata());
    }
}

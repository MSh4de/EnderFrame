package eu.mshade.enderframe.metadata.buffer;

import eu.mshade.enderframe.metadata.MetadataMeaning;
import eu.mshade.enderframe.metadata.MetadataType;

public class PlayerMetadataBuffer extends LivingEntityMetadataBuffer {

    public PlayerMetadataBuffer() {
        this.getMetadataRepository().registerMetadataIndex(15, MetadataType.FLOAT, MetadataMeaning.ADDITIONAL_HEARTS);
        this.getMetadataRepository().registerMetadataIndex(16, MetadataType.VAR_INT, MetadataMeaning.SCORE);
        this.getMetadataRepository().registerMetadataIndex(17, MetadataType.BYTE, MetadataMeaning.SKIN_PART);
        this.getMetadataRepository().registerMetadataIndex(18, MetadataType.BYTE, MetadataMeaning.MAIN_HAND);
        this.getMetadataRepository().registerMetadataIndex(19, MetadataType.NBT, MetadataMeaning.LEFT_SHOULDER_ENTITY_DATA);
        this.getMetadataRepository().registerMetadataIndex(20, MetadataType.NBT, MetadataMeaning.RIGHT_SHOULDER_ENTITY_DATA);
    }


}

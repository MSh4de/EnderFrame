package eu.mshade.enderframe.metadata.buffer;

import eu.mshade.enderframe.metadata.MetadataMeaning;
import eu.mshade.enderframe.metadata.MetadataType;

public class LivingEntityMetadataBuffer extends EntityMetadataBuffer {

    public LivingEntityMetadataBuffer() {
        this.getMetadataRepository().registerMetadataIndex(8, MetadataType.BYTE, MetadataMeaning.LIVING_ENTITY_PROPERTIES);
        this.getMetadataRepository().registerMetadataIndex(9, MetadataType.FLOAT, MetadataMeaning.HEALTH);
        this.getMetadataRepository().registerMetadataIndex(10, MetadataType.VAR_INT, MetadataMeaning.POTION_EFFECT_COLOR);
        this.getMetadataRepository().registerMetadataIndex(11, MetadataType.BOOLEAN, MetadataMeaning.IS_POTION_EFFECT_AMBIENT);
        this.getMetadataRepository().registerMetadataIndex(12, MetadataType.VAR_INT, MetadataMeaning.NUMBER_OF_ARROWS_IN_ENTITY);
        this.getMetadataRepository().registerMetadataIndex(13, MetadataType.VAR_INT, MetadataMeaning.NUMBER_OF_BEE_STRINGERS_IN_ENTITY);
        this.getMetadataRepository().registerMetadataIndex(14, MetadataType.OPT_BLOCK_POSITION, MetadataMeaning.BED_LOCATION);
    }


}

package eu.mshade.enderframe.metadata;

import java.util.HashMap;
import java.util.Map;

public abstract class EntityMetadataController {

    private Map<EntityMetadataType, EntityMetadataBuffer> entityMetadataBufferByType = new HashMap<>();
    private Map<EntityMetadataType, Integer> indexEntityMetadataByType = new HashMap<>();


    public void registerEntityMetadata(int index, EntityMetadataBuffer entityMetadataBuffer, EntityMetadataType... entityMetadataTypes){
        for (EntityMetadataType entityMetadataType : entityMetadataTypes) {
            this.entityMetadataBufferByType.put(entityMetadataType, entityMetadataBuffer);
            this.indexEntityMetadataByType.put(entityMetadataType, index);
        }
    }

    public int getIndexEntityMetadata(EntityMetadataType entityMetadataType){
        return this.indexEntityMetadataByType.get(entityMetadataType);
    }

    public EntityMetadataBuffer getEntityMetadataBuffer(EntityMetadataType entityMetadataType){
        return this.entityMetadataBufferByType.get(entityMetadataType);
    }

}

package eu.mshade.enderframe.entity;

import java.util.HashMap;
import java.util.Map;

public class EntityRepository {

    private final Map<Integer, EntityType> idToEntityType = new HashMap<>();
    private final Map<EntityType, Integer> entityTypeToId = new HashMap<>();

    public void registerEntityTypeId(int id, EntityType entityType){
        this.idToEntityType.put(id, entityType);
        this.entityTypeToId.put(entityType,id);
    }

    public EntityType getEntityTypeById(int id){
        return this.idToEntityType.get(id);
    }

    public int getIdByEntityType(EntityType entityType){
        return this.entityTypeToId.get(entityType);
    }
}

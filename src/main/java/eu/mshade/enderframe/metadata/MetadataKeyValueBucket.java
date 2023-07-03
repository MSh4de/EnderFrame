package eu.mshade.enderframe.metadata;

import eu.mshade.mwork.PrettyString;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MetadataKeyValueBucket implements PrettyString, Cloneable {

    protected final Map<MetadataKey, MetadataKeyValue<?>> metadataKeyValueByMetadataKey = new HashMap<>();
    protected final Set<MetadataKey> metadataKeyUpdated = new HashSet<>();
    protected boolean trackUpdates;

    public MetadataKeyValueBucket(boolean trackUpdates) {
        this.trackUpdates = trackUpdates;
    }

    public MetadataKeyValueBucket() {
        this(false);
    }

    public void setMetadataKeyValue(MetadataKeyValue<?> entityMetadata){
        if (trackUpdates) this.metadataKeyUpdated.add(entityMetadata.getMetadataKey());
        this.metadataKeyValueByMetadataKey.put(entityMetadata.getMetadataKey(), entityMetadata);
    }

    public boolean hasMetadataKeyValue(MetadataKey metadataKey){
        return this.metadataKeyValueByMetadataKey.containsKey(metadataKey);
    }

    public MetadataKeyValue<?> getMetadataKeyValue(MetadataKey metadataKey){
        return this.metadataKeyValueByMetadataKey.get(metadataKey);
    }

    public Collection<MetadataKeyValue<?>> getMetadataKeyValues() {
        return this.metadataKeyValueByMetadataKey.values();
    }

    public Collection<MetadataKey> getMetadataKeys() {
        return this.metadataKeyValueByMetadataKey.keySet();
    }

    public Collection<MetadataKey> consumeUpdatedMetadataKeyValue(){
        if (metadataKeyUpdated.isEmpty()) return Collections.emptySet();
        Set<MetadataKey> copy = new HashSet<>(this.metadataKeyUpdated);
        this.metadataKeyUpdated.clear();
        return copy;
    }

    public boolean visitModified(){
        return !consumeUpdatedMetadataKeyValue().isEmpty();
    }

    public void clear(){
        this.metadataKeyValueByMetadataKey.clear();
        this.metadataKeyUpdated.clear();
    }

    public boolean isEmpty(){
        return this.metadataKeyValueByMetadataKey.isEmpty();
    }

    public void toggleTrackUpdates(boolean trackUpdates){
        this.trackUpdates = trackUpdates;
    }

    @Override
    public String toString() {
        return "MetadataKeyValueBucket{" +
                "metadataKeyValueByMetadataKey=" + metadataKeyValueByMetadataKey.values() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetadataKeyValueBucket that = (MetadataKeyValueBucket) o;
        return Objects.equals(metadataKeyValueByMetadataKey, that.metadataKeyValueByMetadataKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadataKeyValueByMetadataKey);
    }



    @NotNull
    @Override
    public String toPrettyString(int deep) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MetadataKeyValueBucket{").append(System.lineSeparator());
        stringBuilder.append(" ".repeat(deep));
        for (MetadataKeyValue<?> metadataKeyValue : metadataKeyValueByMetadataKey.values()) {
            stringBuilder.append(" ".repeat(deep+1));
            stringBuilder.append(metadataKeyValue.getMetadataKey().getName()).append(": ");
            if(metadataKeyValue.getMetadataValue() instanceof PrettyString){
                stringBuilder.append(((PrettyString) metadataKeyValue.getMetadataValue()).toPrettyString(deep + 1));
            } else {
                stringBuilder.append(metadataKeyValue.getMetadataValue());
            }
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append(" ".repeat(deep));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }


    @NotNull
    @Override
    public String toPrettyString() {
        return toPrettyString(0);
    }

    @Override
    public MetadataKeyValueBucket clone()  {
        MetadataKeyValueBucket metadataKeyValueBucket = new MetadataKeyValueBucket(trackUpdates);
        for (MetadataKeyValue<?> metadataKeyValue : metadataKeyValueByMetadataKey.values()) {
            metadataKeyValueBucket.setMetadataKeyValue(metadataKeyValue.clone());
        }

        metadataKeyValueBucket.metadataKeyUpdated.addAll(metadataKeyUpdated);

        return metadataKeyValueBucket;
    }
}


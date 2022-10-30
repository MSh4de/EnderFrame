import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;

public class TestTrackerMetadata {

    public static void main(String[] args) {
        MetadataKeyValueBucket metadataKeyValueBucket = new MetadataKeyValueBucket();
        metadataKeyValueBucket.setMetadataKeyValue(new HealthEntityMetadata(1F));
        System.out.println(metadataKeyValueBucket.hashCode());
        metadataKeyValueBucket.getMetadataKeyValue(EntityMetadataKey.HEALTH, HealthEntityMetadata.class).setMetadataValue(2F);
        System.out.println(metadataKeyValueBucket.hashCode());
    }
}

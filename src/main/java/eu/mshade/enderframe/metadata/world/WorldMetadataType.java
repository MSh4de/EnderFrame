package eu.mshade.enderframe.metadata.world;

import eu.mshade.enderframe.metadata.MetadataKey;

public enum WorldMetadataType implements MetadataKey {

    NAME(),
    SEED(),
    LEVEL_TYPE(),
    DIMENSION(),
    DIFFICULTY();

    private String name;
    private int index;

    WorldMetadataType(String name) {
        this.name = name;
    }

    WorldMetadataType() {
        this.name = this.name();
    }



    @Override
    public String getName() {
        return this.name();
    }



}

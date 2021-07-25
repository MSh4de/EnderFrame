package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;
import eu.mshade.enderframe.metadata.Pose;

public class PoseMetadata implements Metadata<Pose> {

    private final Pose pose;

    public PoseMetadata(Pose pose) {
        this.pose = pose;
    }

    @Override
    public Pose get() {
        return pose;
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.POSE;
    }
}

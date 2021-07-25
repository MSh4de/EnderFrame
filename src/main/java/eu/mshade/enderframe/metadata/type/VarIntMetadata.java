package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;

public class VarIntMetadata extends IntegerMetadata {

    public VarIntMetadata(int aInt) {
        super(aInt);
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.VAR_INT;
    }
}

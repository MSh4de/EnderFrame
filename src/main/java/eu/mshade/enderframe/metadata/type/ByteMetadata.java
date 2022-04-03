package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;

public class ByteMetadata implements Metadata<Byte> {

    private final byte aByte;

    public ByteMetadata(byte aByte) {
        this.aByte = aByte;
    }

    public ByteMetadata(int aByte) {
        this.aByte = (byte) aByte;
    }

    public ByteMetadata(boolean aByte) {
        this(aByte ? 1 : 0);
    }



    @Override
    public Byte get() {
        return aByte;
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.BYTE;
    }
}

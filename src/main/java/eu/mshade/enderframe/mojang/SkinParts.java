package eu.mshade.enderframe.mojang;

public class SkinParts {

    private boolean cape;
    private boolean jacket;
    private boolean leftSleeve;
    private boolean rightSleeve;
    private boolean leftPantsLeg;
    private boolean rightPantsLeg;
    private boolean hat;
    private boolean unused;

    public SkinParts(boolean cape, boolean jacket, boolean leftSleeve, boolean rightSleeve, boolean leftPantsLeg, boolean rightPantsLeg, boolean hat, boolean unused) {
        this.cape = cape;
        this.jacket = jacket;
        this.leftSleeve = leftSleeve;
        this.rightSleeve = rightSleeve;
        this.leftPantsLeg = leftPantsLeg;
        this.rightPantsLeg = rightPantsLeg;
        this.hat = hat;
        this.unused = unused;
    }

    public static SkinParts fromByte(byte b){

        boolean cape = b == (byte) (b | 0x01);

        boolean jacket = b == (byte) (b | 0x02);

        boolean leftSleeve = b == (byte) (b | 0x04);

        boolean rightSleeve = b == (byte) (b | 0x08);

        boolean leftPantsLeg = b == (byte) (b | 0x10);

        boolean rightPantsLeg = b == (byte) (b | 0x20);

        boolean hat = b == (byte) (b | 0x40);

        boolean unused = b == (byte) (b |0x80);

        return new SkinParts(cape,jacket,leftSleeve,rightSleeve,leftPantsLeg,rightPantsLeg,hat,unused);
    }

    public byte toByte(){
        byte b = 0;

        if (cape) b = (byte) (b | 0x01);

        if (jacket) b = (byte) (b | 0x02);

        if (leftSleeve) b = (byte) (b | 0x04);

        if (rightSleeve) b = (byte) (b | 0x08);

        if (leftPantsLeg) b = (byte) (b | 0x10);

        if (rightPantsLeg) b = (byte) (b | 0x20);

        if (hat) b = (byte) (b | 0x40);

        if(unused) b = (byte) (b |0x80);

        return b;
    }

    @Override
    public String toString() {
        return "SkinParts{" +
                "cape=" + cape +
                ", jacket=" + jacket +
                ", leftSleeve=" + leftSleeve +
                ", rightSleeve=" + rightSleeve +
                ", leftPantsLeg=" + leftPantsLeg +
                ", rightPantsLeg=" + rightPantsLeg +
                ", hat=" + hat +
                ", unused=" + unused +
                '}';
    }
}

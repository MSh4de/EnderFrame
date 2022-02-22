package eu.mshade.enderframe.mojang;

public class SkinParts {

    private boolean cape;
    private boolean jacket;
    private boolean leftSleeve;
    private boolean rightSleeve;
    private boolean leftPantsLeg;
    private boolean rightPantsLeg;
    private boolean hat;

    public SkinParts(boolean cape, boolean jacket, boolean leftSleeve, boolean rightSleeve, boolean leftPantsLeg, boolean rightPantsLeg, boolean hat) {
        this.cape = cape;
        this.jacket = jacket;
        this.leftSleeve = leftSleeve;
        this.rightSleeve = rightSleeve;
        this.leftPantsLeg = leftPantsLeg;
        this.rightPantsLeg = rightPantsLeg;
        this.hat = hat;
    }

    public boolean isCape() {
        return cape;
    }

    public SkinParts setCape(boolean cape) {
        this.cape = cape;
        return this;
    }

    public boolean isJacket() {
        return jacket;
    }

    public SkinParts setJacket(boolean jacket) {
        this.jacket = jacket;
        return this;
    }

    public boolean isLeftSleeve() {
        return leftSleeve;
    }

    public SkinParts setLeftSleeve(boolean leftSleeve) {
        this.leftSleeve = leftSleeve;
        return this;
    }

    public boolean isRightSleeve() {
        return rightSleeve;
    }

    public SkinParts setRightSleeve(boolean rightSleeve) {
        this.rightSleeve = rightSleeve;
        return this;
    }

    public boolean isLeftPantsLeg() {
        return leftPantsLeg;
    }

    public SkinParts setLeftPantsLeg(boolean leftPantsLeg) {
        this.leftPantsLeg = leftPantsLeg;
        return this;
    }

    public boolean isRightPantsLeg() {
        return rightPantsLeg;
    }

    public SkinParts setRightPantsLeg(boolean rightPantsLeg) {
        this.rightPantsLeg = rightPantsLeg;
        return this;
    }

    public boolean isHat() {
        return hat;
    }

    public SkinParts setHat(boolean hat) {
        this.hat = hat;
        return this;
    }


    public static SkinParts fromByte(byte b) {

        boolean cape = b == (byte) (b | 0x01);

        boolean jacket = b == (byte) (b | 0x02);

        boolean leftSleeve = b == (byte) (b | 0x04);

        boolean rightSleeve = b == (byte) (b | 0x08);

        boolean leftPantsLeg = b == (byte) (b | 0x10);

        boolean rightPantsLeg = b == (byte) (b | 0x20);

        boolean hat = b == (byte) (b | 0x40);

        return new SkinParts(cape, jacket, leftSleeve, rightSleeve, leftPantsLeg, rightPantsLeg, hat);
    }

    public byte toByte() {
        byte b = 0;

        if (cape) b = (byte) (b | 0x01);

        if (jacket) b = (byte) (b | 0x02);

        if (leftSleeve) b = (byte) (b | 0x04);

        if (rightSleeve) b = (byte) (b | 0x08);

        if (leftPantsLeg) b = (byte) (b | 0x10);

        if (rightPantsLeg) b = (byte) (b | 0x20);

        if (hat) b = (byte) (b | 0x40);

        if (cape && jacket && leftSleeve && rightSleeve && leftPantsLeg && rightPantsLeg && hat) b = (byte) (b | 0x80);

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
                '}';
    }
}

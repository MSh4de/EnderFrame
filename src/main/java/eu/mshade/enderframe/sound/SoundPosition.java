package eu.mshade.enderframe.sound;

public class SoundPosition {

    protected final int x;
    protected final int y;
    protected final int z;

    public SoundPosition(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}

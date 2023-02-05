package eu.mshade.enderframe.world.border;

public class WorldBorderCenter {

    protected final double x;
    protected final double z;

    public WorldBorderCenter(double x, double z) {
        this.x = x;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "WorldBorderCenter{" +
                "x=" + x +
                ", z=" + z +
                '}';
    }
}

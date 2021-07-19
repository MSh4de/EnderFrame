package eu.mshade.enderframe.world;

import java.util.Objects;

public class Location implements Cloneable {

    private WorldBuffer world;
    private double x;
    private double y;
    private double z;
    private float pitch;
    private float yaw;

    public Location(WorldBuffer world, double x, double y, double z) {
        this(world, x, y, z, 0, 0);
    }

    public Location(WorldBuffer world, double x, double y, double z, float pitch, float yaw) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public WorldBuffer getWorld() {
        return world;
    }

    public double getX() {
        return x;
    }

    public int getBlockX(){
        return (int) Math.floor(x);
    }

    public Location setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public int getBlockY(){
        return (int) Math.floor(y);
    }

    public Location setY(double y) {
        this.y = y;
        return this;
    }

    public double getZ() {
        return z;
    }

    public int getBlockZ(){
        return (int) Math.floor(z);
    }

    public Location setZ(double z) {
        this.z = z;
        return this;
    }

    public float getPitch() {
        return pitch;
    }

    public Location setPitch(float pitch) {
        this.pitch = pitch;
        return this;
    }

    public float getYaw() {
        return yaw;
    }

    public Location setYaw(float yaw) {
        this.yaw = yaw;
        return this;
    }

    public Location multiply(double m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    public int getChunkX(){
        return getBlockX() >> 4;
    }

    public int getChunkZ(){
        return getBlockZ() >> 4;
    }

    public ChunkBuffer getChunkBuffer(){
        return world.getChunkBuffer(getChunkX(), getChunkZ());
    }

    public Vector getDirection() {
        Vector vector = new Vector();

        double rotX = this.getYaw();
        double rotY = this.getPitch();

        vector.setY(-Math.sin(Math.toRadians(rotY)));

        double xz = Math.cos(Math.toRadians(rotY));

        vector.setX(-xz * Math.sin(Math.toRadians(rotX)));
        vector.setZ(xz * Math.cos(Math.toRadians(rotX)));

        return vector;
    }


    public Location setDirection(Vector vector) {
        final double _2PI = 2 * Math.PI;
        final double x = vector.getX();
        final double z = vector.getZ();

        if (x == 0 && z == 0) {
            pitch = vector.getY() > 0 ? -90 : 90;
            return this;
        }

        double theta = Math.atan2(-x, z);
        yaw = (float) Math.toDegrees((theta + _2PI) % _2PI);

        double x2 = Math.pow(x, 2);
        double z2 = Math.pow(z, 2);
        double xz = Math.sqrt(x2 + z2);
        pitch = (float) Math.toDegrees(Math.atan(-vector.getY() / xz));

        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Double.compare(location.x, x) == 0 && Double.compare(location.y, y) == 0 && Double.compare(location.z, z) == 0 && Float.compare(location.pitch, pitch) == 0 && Float.compare(location.yaw, yaw) == 0 && Objects.equals(world, location.world);
    }

    @Override
    public int hashCode() {
        return Objects.hash(world, x, y, z, pitch, yaw);
    }

    @Override
    public Location clone() {
        try {
            return (Location) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}

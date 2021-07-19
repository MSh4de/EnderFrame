package eu.mshade.enderframe.world;

import java.util.Objects;

public class Position {

    private double x, y, z;
    private float yaw, pitch;
    private boolean ground;


    public Position(double x, double y, double z, boolean ground) {
        this(x, y, z, 0, 0, ground);
    }

    public Position(boolean ground) {
        this(0, 0, 0, 0, 0, ground);
    }

    public Position(float yaw, float pitch, boolean ground) {
        this(0, 0, 0, yaw, pitch, ground);
    }

    public Position(double x, double y, double z, float yaw, float pitch, boolean ground) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.ground = ground;
    }

    public double getX() {
        return x;
    }

    public Position setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public Position setY(double y) {
        this.y = y;
        return this;
    }

    public double getZ() {
        return z;
    }

    public Position setZ(double z) {
        this.z = z;
        return this;
    }

    public float getYaw() {
        return yaw;
    }

    public Position setYaw(float yaw) {
        this.yaw = yaw;
        return this;
    }

    public float getPitch() {
        return pitch;
    }

    public Position setPitch(float pitch) {
        this.pitch = pitch;
        return this;
    }

    public boolean isGround() {
        return ground;
    }

    public Position setGround(boolean ground) {
        this.ground = ground;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Double.compare(position.x, x) == 0 && Double.compare(position.y, y) == 0 && Double.compare(position.z, z) == 0 && Float.compare(position.yaw, yaw) == 0 && Float.compare(position.pitch, pitch) == 0 && ground == position.ground;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, yaw, pitch, ground);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", yaw=" + yaw +
                ", pitch=" + pitch +
                ", ground=" + ground +
                '}';
    }
}

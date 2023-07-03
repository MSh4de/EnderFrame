package eu.mshade.enderframe.world;

import java.util.Objects;

public class Vector implements Cloneable {

    protected double x;
    protected double y;
    protected double z;

    public static final Vector ZERO = new Vector(0, 0, 0);

    public Vector() {
        this(0, 0, 0);
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public int getBlockX(){
        return (int) Math.floor(x);
    }

    public Vector setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public int getBlockY(){
        return (int) Math.floor(y);
    }
    public Vector setY(double y) {
        this.y = y;
        return this;
    }

    public double getZ() {
        return z;
    }

    public int getBlockZ(){
        return (int) Math.floor(z);
    }

    public Vector setZ(double z) {
        this.z = z;
        return this;
    }

    public Vector add(Vector vec) {
        x += vec.x;
        y += vec.y;
        z += vec.z;
        return this;
    }

    public Vector add(double x, double y, double z){
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public Vector add(int x, int y, int z){
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public Vector subtract(Vector vec) {
        x -= vec.x;
        y -= vec.y;
        z -= vec.z;
        return this;
    }

    public Vector multiply(Vector vec) {
        x *= vec.x;
        y *= vec.y;
        z *= vec.z;
        return this;
    }

    public Vector divide(Vector vec) {
        x /= vec.x;
        y /= vec.y;
        z /= vec.z;
        return this;
    }

    public float taxicabDistance(Vector vec) {
        return (float) (Math.abs(vec.x - x) + Math.abs(vec.y - y) + Math.abs(vec.z - z));
    }

    public float chebyshevDistance(Vector vec) {
        return (float) Math.max(Math.max(Math.abs(vec.x - x), Math.abs(vec.y - y)), Math.abs(vec.z - z));
    }

    public float distance(Vector vec) {
        return (float) Math.sqrt(distanceSquared(vec));
    }

    public double distanceSquared(Vector vec) {
        return Math.pow(vec.x - x, 2) + Math.pow(vec.y - y, 2) + Math.pow(vec.z - z, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;
        Vector vector = (Vector) o;
        return Double.compare(vector.x, x) == 0 && Double.compare(vector.y, y) == 0 && Double.compare(vector.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public Vector clone() {
        try {
            return (Vector) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

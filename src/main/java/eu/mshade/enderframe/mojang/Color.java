package eu.mshade.enderframe.mojang;

import com.google.common.collect.ImmutableMap;

import java.awt.*;
import java.beans.ConstructorProperties;
import java.awt.image.ColorModel;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.color.ColorSpace;
import java.util.Map;

public class Color {

    public static final Color RED = fromRGB(0xb02e26);

    public static final Color ORANGE = fromRGB(0xf9801d);

    public static final Color YELLOW = fromRGB(0xfed83d);

    public static final Color LIME = fromRGB(0x80c71f);

    public static final Color GREEN = fromRGB(0x5e7c16);

    public static final Color LIGHT_BLUE = fromRGB(0x3ab3da);

    public static final Color CYAN = fromRGB(0x169c9c);

    public static final Color BLUE = fromRGB(0x3c44aa);

    public static final Color PURPLE = fromRGB(0x8932b8);

    public static final Color MAGENTA = fromRGB(0xc74ebd);

    public static final Color PINK = fromRGB(0xf38baa);

    public static final Color WHITE = fromRGB(0xf9fffe);

    public static final Color LIGHT_GRAY = fromRGB(0x9d9d97);

    public static final Color GRAY = fromRGB(0x474f52);

    public static final Color BLACK = fromRGB(0x1d1d21);

    public static final Color BROWN = fromRGB(0x835432);

    private static final int BIT_MASK = 0xff;

    private final byte red;
    private final byte green;
    private final byte blue;

    /**
     * Creates a new Color object from a red, green, and blue
     *
     * @param red integer from 0-255
     * @param green integer from 0-255
     * @param blue integer from 0-255
     * @return a new Color object for the red, green, blue
     * @throws IllegalArgumentException if any value is strictly {@literal >255 or <0}
     */
    public static Color fromRGB(int red, int green, int blue) throws IllegalArgumentException {
        return new Color(red, green, blue);
    }

    /**
     * Creates a new Color object from a blue, green, and red
     *
     * @param blue integer from 0-255
     * @param green integer from 0-255
     * @param red integer from 0-255
     * @return a new Color object for the red, green, blue
     * @throws IllegalArgumentException if any value is strictly {@literal >255 or <0}
     */
    public static Color fromBGR(int blue, int green, int red) throws IllegalArgumentException {
        return new Color(red, green, blue);
    }

    /**
     * Creates a new color object from an integer that contains the red,
     * green, and blue bytes in the lowest order 24 bits.
     *
     * @param rgb the integer storing the red, green, and blue values
     * @return a new color object for specified values
     * @throws IllegalArgumentException if any data is in the highest order 8
     *     bits
     */
    public static Color fromRGB(int rgb) throws IllegalArgumentException {
        return fromRGB(rgb >> 16 & BIT_MASK, rgb >> 8 & BIT_MASK, rgb >> 0 & BIT_MASK);
    }

    /**
     * Creates a new color object from an integer that contains the blue,
     * green, and red bytes in the lowest order 24 bits.
     *
     * @param bgr the integer storing the blue, green, and red values
     * @return a new color object for specified values
     * @throws IllegalArgumentException if any data is in the highest order 8
     *     bits
     */
    public static Color fromBGR(int bgr) throws IllegalArgumentException {
        return fromBGR(bgr >> 16 & BIT_MASK, bgr >> 8 & BIT_MASK, bgr >> 0 & BIT_MASK);
    }

    private Color(int red, int green, int blue) {

        this.red = (byte) red;
        this.green = (byte) green;
        this.blue = (byte) blue;
    }

    /**
     * Gets the red component
     *
     * @return red component, from 0 to 255
     */
    public int getRed() {
        return BIT_MASK & red;
    }

    /**
     * Creates a new Color object with specified component
     *
     * @param red the red component, from 0 to 255
     * @return a new color object with the red component
     */
    public Color setRed(int red) {
        return fromRGB(red, getGreen(), getBlue());
    }

    /**
     * Gets the green component
     *
     * @return green component, from 0 to 255
     */
    public int getGreen() {
        return BIT_MASK & green;
    }

    /**
     * Creates a new Color object with specified component
     *
     * @param green the red component, from 0 to 255
     * @return a new color object with the red component
     */
    public Color setGreen(int green) {
        return fromRGB(getRed(), green, getBlue());
    }

    /**
     * Gets the blue component
     *
     * @return blue component, from 0 to 255
     */
    public int getBlue() {
        return BIT_MASK & blue;
    }

    /**
     * Creates a new Color object with specified component
     *
     * @param blue the red component, from 0 to 255
     * @return a new color object with the red component
     */
    public Color setBlue(int blue) {
        return fromRGB(getRed(), getGreen(), blue);
    }

    /**
     *
     * @return An integer representation of this color, as 0xRRGGBB
     */
    public int asRGB() {
        return getRed() << 16 | getGreen() << 8 | getBlue() << 0;
    }

    /**
     *
     * @return An integer representation of this color, as 0xBBGGRR
     */
    public int asBGR() {
        return getBlue() << 16 | getGreen() << 8 | getRed() << 0;
    }

    /**
     * Creates a new color with its RGB components changed as if it was dyed
     * with the colors passed in, replicating vanilla workbench dyeing
     *
     * @param colors The colors to dye with
     * @return A new color with the changed rgb components
     */
    public Color mixColors(Color... colors) {

        int totalRed = this.getRed();
        int totalGreen = this.getGreen();
        int totalBlue = this.getBlue();
        int totalMax = Math.max(Math.max(totalRed, totalGreen), totalBlue);
        for (Color color : colors) {
            totalRed += color.getRed();
            totalGreen += color.getGreen();
            totalBlue += color.getBlue();
            totalMax += Math.max(Math.max(color.getRed(), color.getGreen()), color.getBlue());
        }

        float averageRed = totalRed / (colors.length + 1);
        float averageGreen = totalGreen / (colors.length + 1);
        float averageBlue = totalBlue / (colors.length + 1);
        float averageMax = totalMax / (colors.length + 1);

        float maximumOfAverages = Math.max(Math.max(averageRed, averageGreen), averageBlue);
        float gainFactor = averageMax / maximumOfAverages;

        return Color.fromRGB((int) (averageRed * gainFactor), (int) (averageGreen * gainFactor), (int) (averageBlue * gainFactor));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Color)) {
            return false;
        }
        final Color that = (Color) o;
        return this.blue == that.blue && this.green == that.green && this.red == that.red;
    }

    @Override
    public int hashCode() {
        return asRGB() ^ Color.class.hashCode();
    }

    public Map<String, Object> serialize() {
        return ImmutableMap.<String, Object>of(
                "RED", getRed(),
                "BLUE", getBlue(),
                "GREEN", getGreen()
        );
    }

    @SuppressWarnings("javadoc")
    public static Color deserialize(Map<String, Object> map) {
        return fromRGB(
                asInt("RED", map),
                asInt("GREEN", map),
                asInt("BLUE", map)
        );
    }

    private static int asInt(String string, Map<String, Object> map) {
        Object value = map.get(string);
        if (value == null) {
            throw new IllegalArgumentException(string + " not in map " + map);
        }
        if (!(value instanceof Number)) {
            throw new IllegalArgumentException(string + '(' + value + ") is not a number");
        }
        return ((Number) value).intValue();
    }

    @Override
    public String toString() {
        return "Color:[rgb0x" + Integer.toHexString(getRed()).toUpperCase() + Integer.toHexString(getGreen()).toUpperCase() + Integer.toHexString(getBlue()).toUpperCase() + "]";
    }

}

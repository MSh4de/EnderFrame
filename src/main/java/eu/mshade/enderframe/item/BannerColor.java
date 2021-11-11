package eu.mshade.enderframe.item;

public enum BannerColor {
    WHITE(0xF),
    ORANGE(0xE),
    MAGENTA(0xD),
    LIGHT_BLUE(0xC),
    YELLOW(0xB),
    LIME(0xA),
    PINK(0x9),
    GRAY(0x8),
    LIGHT_GRAY(0x7),
    CYAN(0x6),
    PURPLE(0x5),
    BLUE(0x4),
    BROWN(0x3),
    GREEN(0x2),
    RED(0x1),
    BLACK(0x0);

    private final byte dyeData;
    private final static BannerColor[] BY_DYE_DATA;

    static {
        BY_DYE_DATA = values();
        for (BannerColor color : values()) {
            BY_DYE_DATA[color.dyeData & 0xff] = color;
        }
    }
    BannerColor(int dyeData) {
        this.dyeData = (byte) dyeData;
    }

    public byte getDyeData() {
        return dyeData;
    }

    public static BannerColor getByDyeData(final byte data) {
        int i = 0xff & data;
        if (i >= BY_DYE_DATA.length) {
            return null;
        }
        return BY_DYE_DATA[i];
    }
}

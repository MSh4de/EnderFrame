package eu.mshade.enderframe.item;

public class Pattern {

    private BannerColor bannerColor;
    private BannerPattern bannerPattern;

    public Pattern(BannerColor bannerColor, BannerPattern bannerPattern) {
        this.bannerColor = bannerColor;
        this.bannerPattern = bannerPattern;
    }

    public BannerColor getBannerColor() {
        return bannerColor;
    }

    public Pattern setBannerColor(BannerColor bannerColor) {
        this.bannerColor = bannerColor;
        return this;
    }

    public BannerPattern getBannerPattern() {
        return bannerPattern;
    }

    public Pattern setBannerPattern(BannerPattern bannerPattern) {
        this.bannerPattern = bannerPattern;
        return this;
    }
}

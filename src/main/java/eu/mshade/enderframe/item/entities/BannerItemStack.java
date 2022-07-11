package eu.mshade.enderframe.item.entities;

import eu.mshade.enderframe.item.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BannerItemStack extends ItemStack {

    private BannerColor color = BannerColor.YELLOW;
    private final List<Pattern> patterns = new ArrayList<>();

    public BannerItemStack(MaterialKey material, int count, int durability) {
        super(material, count, durability);
    }

    public BannerColor getColor() {
        return color;
    }

    public BannerItemStack setColor(BannerColor color) {
        this.color = color;
        return this;
    }

    public List<Pattern> getPatterns() {
        return patterns;
    }

    public BannerItemStack addPattern(Pattern...patterns){
        this.patterns.addAll(Arrays.stream(patterns).collect(Collectors.toList()));
        return this;
    }

    public BannerItemStack removePattern(Pattern pattern){
        this.patterns.remove(pattern);
        return this;
    }
}

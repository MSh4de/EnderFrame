package eu.mshade.enderframe.item.entities;

import eu.mshade.enderframe.item.BannerColor;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.item.Pattern;
import eu.mshade.enderframe.mojang.chat.TextComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BannerItemStack extends ItemStack {

    private BannerColor color = BannerColor.YELLOW;
    private final List<Pattern> patterns = new ArrayList<>();

    public BannerItemStack(Material material, int count, int durability) {
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

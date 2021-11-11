package eu.mshade.enderframe.item.entities;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.mojang.chat.TextComponent;

import java.awt.*;

public class BannerItemStack extends ItemStack {

    private Color color = Color.YELLOW;

    public BannerItemStack(Material material, int count, int durability) {
        super(material, count, durability);
    }

    public Color getColor() {
        return color;
    }

    public BannerItemStack setColor(Color color) {
        this.color = color;
        return this;
    }
}

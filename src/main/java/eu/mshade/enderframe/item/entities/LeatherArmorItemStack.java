package eu.mshade.enderframe.item.entities;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.Material;

import java.awt.*;

public class LeatherClothItemStack extends ItemStack {

    private Color color = Color.YELLOW;

    public LeatherClothItemStack(Material material, int count, int durability) {
        super(material, count, durability);
    }

    public Color getColor() {
        return color;
    }

    public LeatherClothItemStack setColor(Color color) {
        this.color = color;
        return this;
    }
}

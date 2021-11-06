package eu.mshade.enderframe.item;

import java.awt.*;

public class LeatherCloth extends ItemStack {

    private Color color = Color.YELLOW;

    public LeatherCloth(Material material, int count, int durability) {
        super(material, count, durability);
    }

    public Color getColor() {
        return color;
    }

    public LeatherCloth setColor(Color color) {
        this.color = color;
        return this;
    }
}

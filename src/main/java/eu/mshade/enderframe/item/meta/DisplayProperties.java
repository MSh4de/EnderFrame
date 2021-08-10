package eu.mshade.enderframe.item.meta;

import eu.mshade.enderframe.item.ItemMeta;

import java.awt.*;
import java.util.List;

public interface DisplayProperties extends ItemMeta {

    String getName();

    Color getColor();

    List<String> getLore();

}

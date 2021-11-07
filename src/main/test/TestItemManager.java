import eu.mshade.enderframe.item.ItemStackManager;
import eu.mshade.enderframe.item.Material;

import java.awt.*;

public class TestItemManager {


    public static void main(String[] args) {

        System.out.println(new Color(0, 0, 0).getRGB());
        ItemStackManager<MaterialData, Object> itemStackManager = new ItemStackManager<>(new CommonItemStackRewriter()){};
        itemStackManager.registerMaterialWithWrap(Material.RED_WOOL, new MaterialData(35, 14));



        System.out.println(itemStackManager.getMaterialByWrap(new MaterialData(35, 14)));


    }

}

package eu.mshade.enderframe.item;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum ItemFlag {

    HIDE_ENCHANTS,

    HIDE_ATTRIBUTES,

    HIDE_UNBREAKABLE,

    HIDE_DESTROYS,

    HIDE_PLACED_ON,

    HIDE_POTION_EFFECTS;

    public static int toByte(Collection<ItemFlag> itemFlags){
        int b = 0;
        for (ItemFlag itemFlag : itemFlags) {
            b |= getBitModifier(itemFlag);
        }
        return b;
    }

    public static Set<ItemFlag> fromByte(int v){
        Set<ItemFlag> itemFlags = new HashSet<>();
        for (ItemFlag itemFlag : ItemFlag.values()) {
            if ((v & getBitModifier(itemFlag)) != 0) {
                itemFlags.add(itemFlag);
            }
        }
        return itemFlags;
    }

    private static byte getBitModifier(ItemFlag hideFlag) {
        return (byte) (1 << hideFlag.ordinal());
    }

}

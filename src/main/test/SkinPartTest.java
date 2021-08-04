import eu.mshade.enderframe.mojang.SkinParts;

public class SkinPartTest {

    public static void main(String[] args) {
        SkinParts skinParts = new SkinParts(true,true,true,true,true,true,true,false);
        System.out.println(skinParts.toByte());
        System.out.println(SkinParts.fromByte((byte) 0));
    }
}

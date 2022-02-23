package eu.mshade.enderframe.entity;

public abstract class FurnaceMinecart extends Minecart {

    protected boolean powered;


    public boolean isPowered() {
        return powered;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }
}

package eu.mshade.enderframe.entity;

public abstract class FurnaceMinecart extends Minecart {

    private boolean isPowered;

    public FurnaceMinecart(boolean isPowered) {
        this.isPowered = isPowered;
    }

    public boolean isPowered() {
        return isPowered;
    }

    public void setPowered(boolean powered) {
        isPowered = powered;
    }
}

package eu.mshadeproduction.enderframe.event;

public interface Cancellable {

    boolean isCancelled();

    void setCancelled(boolean cancel);

}

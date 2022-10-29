package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.metadata.ActionType;

public class PacketEntityActionEvent implements PacketEvent {

    private Player player;
    private final ActionType actionType;
    private final int actionParameter;

    public PacketEntityActionEvent(Player player, ActionType actionType, int actionParameter) {
        this.player = player;
        this.actionType = actionType;
        this.actionParameter = actionParameter;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public int getActionParameter() {
        return actionParameter;
    }

    public Player getPlayer() {
        return player;
    }
}

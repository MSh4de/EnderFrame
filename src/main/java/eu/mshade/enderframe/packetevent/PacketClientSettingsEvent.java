package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.mojang.SkinParts;

public class PacketClientSettingsEvent implements PacketEvent {

    private final Player player;
    private final String locale;
    private final byte viewDistance;
    private final byte chatMode;
    private final boolean chatColors;
    private final SkinParts skinParts;

    public PacketClientSettingsEvent(Player player, String locale, byte viewDistance, byte chatMode, boolean chatColors, SkinParts skinParts) {
        this.player = player;
        this.locale = locale;
        this.viewDistance = viewDistance;
        this.chatMode = chatMode;
        this.chatColors = chatColors;
        this.skinParts = skinParts;
    }

    public Player getPlayer() {
        return player;
    }

    public String getLocale() {
        return locale;
    }

    public byte getViewDistance() {
        return viewDistance;
    }

    public byte getChatMode() {
        return chatMode;
    }

    public boolean isChatColors() {
        return chatColors;
    }

    public SkinParts getDisplayedSkinParts() {
        return skinParts;
    }


}

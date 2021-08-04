package eu.mshade.enderframe.event.entity;

import eu.mshade.enderframe.event.PacketEvent;
import eu.mshade.enderframe.mojang.SkinParts;

public class PacketClientSettingsEvent implements PacketEvent {

    private String locale;
    private byte viewDistance;
    private byte chatMode;
    private boolean chatColors;
    private SkinParts skinParts;

    public PacketClientSettingsEvent(String locale, byte viewDistance, byte chatMode, boolean chatColors, SkinParts skinParts) {
        this.locale = locale;
        this.viewDistance = viewDistance;
        this.chatMode = chatMode;
        this.chatColors = chatColors;
        this.skinParts = skinParts;
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

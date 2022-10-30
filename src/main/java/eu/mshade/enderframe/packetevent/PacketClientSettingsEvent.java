package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.mojang.SkinPart;

public class PacketClientSettingsEvent implements PacketEvent {

    private final String locale;
    private final byte viewDistance;
    private final byte chatMode;
    private final boolean chatColors;
    private final SkinPart skinPart;

    public PacketClientSettingsEvent(String locale, byte viewDistance, byte chatMode, boolean chatColors, SkinPart skinPart) {
        this.locale = locale;
        this.viewDistance = viewDistance;
        this.chatMode = chatMode;
        this.chatColors = chatColors;
        this.skinPart = skinPart;
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

    public SkinPart getDisplayedSkinParts() {
        return skinPart;
    }


}

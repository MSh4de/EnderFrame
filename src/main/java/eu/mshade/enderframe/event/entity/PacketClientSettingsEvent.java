package eu.mshade.enderframe.event.entity;

import eu.mshade.enderframe.event.PacketEvent;

public class PacketClientSettingsEvent implements PacketEvent {

    private String locale;
    private byte viewDistance;
    private byte chatMode;
    private boolean chatColors;
    private short displayedSkinParts;

    public PacketClientSettingsEvent(String locale, byte viewDistance, byte chatMode, boolean chatColors, short displayedSkinParts) {
        this.locale = locale;
        this.viewDistance = viewDistance;
        this.chatMode = chatMode;
        this.chatColors = chatColors;
        this.displayedSkinParts = displayedSkinParts;
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

    public short getDisplayedSkinParts() {
        return displayedSkinParts;
    }

    @Override
    public String toString() {
        return "PacketClientSettingsEvent{" +
                "locale='" + locale + '\'' +
                ", viewDistance=" + viewDistance +
                ", chatMode=" + chatMode +
                ", chatColors=" + chatColors +
                ", displayedSkinParts=" + displayedSkinParts +
                '}';
    }
}

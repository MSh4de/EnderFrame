package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.mojang.SkinPart;

public class MinecraftPacketClientSettingsEvent implements MinecraftPacketEvent {

    private final Player player;
    private final String locale;
    private final byte viewDistance;
    private final byte chatMode;
    private final boolean chatColors;
    private final SkinPart skinPart;

    public MinecraftPacketClientSettingsEvent(Player player, String locale, byte viewDistance, byte chatMode, boolean chatColors, SkinPart skinPart) {
        this.player = player;
        this.locale = locale;
        this.viewDistance = viewDistance;
        this.chatMode = chatMode;
        this.chatColors = chatColors;
        this.skinPart = skinPart;
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

    public SkinPart getDisplayedSkinParts() {
        return skinPart;
    }


}

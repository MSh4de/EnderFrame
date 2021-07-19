package eu.mshade.enderframe.mojang.chat;

public enum TextPosition {

    CHAT(0),
    SYSTEM(1),
    HOT_BAR(2);

    private final int id;

    TextPosition(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

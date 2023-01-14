package eu.mshade.enderframe.mojang.chat;

public class TextHoverEvent {

    protected TextHoverEventType type;
    protected String value;

    private TextHoverEvent(String value, TextHoverEventType type) {
        this.value = value;
        this.type = type;
    }

    public static TextHoverEvent from(String value, TextHoverEventType type){
        return new TextHoverEvent(value, type);
    }

    public TextHoverEventType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

}

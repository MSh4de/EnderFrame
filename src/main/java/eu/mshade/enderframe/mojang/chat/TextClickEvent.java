package eu.mshade.enderframe.mojang.chat;

public class TextClickEvent {

    private String value;
    private TextClickEventType action;


    private TextClickEvent() { }

    public static TextClickEvent of(String value, TextClickEventType action){
        return new TextClickEvent(value, action);
    }

    protected TextClickEvent(String value, TextClickEventType action) {
        this.value = value;
        this.action = action;
    }

    public String getValue() {
        return value;
    }

    public TextClickEventType getAction() {
        return action;
    }
}

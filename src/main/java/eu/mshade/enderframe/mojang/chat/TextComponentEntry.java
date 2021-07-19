package eu.mshade.enderframe.mojang.chat;


public class TextComponentEntry {

    private String text;
    private String color = ChatColor.WHITE.getName();
    private boolean bold = false;
    private boolean italic = false;
    private boolean strikethrough = false;
    private boolean obfuscated = false;
    private TextClickEvent clickEvent;

    private TextComponentEntry() {
    }

    protected TextComponentEntry(String text) {
        this.text = text;
    }

    public static TextComponentEntry of(String text){
        return new TextComponentEntry(text);
    }

    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }

    public TextComponentEntry withColor(String color) {
        this.color = color;
        return this;
    }

    public boolean isBold() {
        return bold;
    }

    public TextComponentEntry withBold(boolean bold) {
        this.bold = bold;
        return this;
    }

    public boolean isItalic() {
        return italic;
    }

    public TextComponentEntry withItalic(boolean italic) {
        this.italic = italic;
        return this;
    }

    public boolean isStrikethrough() {
        return strikethrough;
    }

    public TextComponentEntry withStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
        return this;
    }

    public boolean isObfuscated() {
        return obfuscated;
    }

    public TextComponentEntry withObfuscated(boolean obfuscated) {
        this.obfuscated = obfuscated;
        return this;
    }

    public TextClickEvent getClickEvent() {
        return clickEvent;
    }

    public TextComponentEntry withClickEvent(TextClickEvent clickEvent) {
        this.clickEvent = clickEvent;
        return this;
    }
}

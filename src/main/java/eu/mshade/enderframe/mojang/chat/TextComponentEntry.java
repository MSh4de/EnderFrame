package eu.mshade.enderframe.mojang.chat;


public class TextComponentEntry {

    private String text;
    private String color = ChatColor.WHITE.getName();
    private boolean bold = false;
    private boolean italic = false;
    private boolean strikethrough = false;
    private boolean obfuscated = false;
    private boolean underlined;
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

    public String toLegacyText(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ChatColor.of(getColor()));
        if (bold) stringBuilder.append(ChatColor.BOLD);
        if (italic) stringBuilder.append(ChatColor.ITALIC);
        if (strikethrough) stringBuilder.append(ChatColor.STRIKETHROUGH);
        if (obfuscated) stringBuilder.append(ChatColor.MAGIC);
        if (underlined) stringBuilder.append(ChatColor.UNDERLINE);
        stringBuilder.append(getText());

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "TextComponentEntry{" +
                "text='" + text + '\'' +
                ", color='" + color + '\'' +
                ", bold=" + bold +
                ", italic=" + italic +
                ", strikethrough=" + strikethrough +
                ", obfuscated=" + obfuscated +
                ", clickEvent=" + clickEvent +
                '}';
    }
}

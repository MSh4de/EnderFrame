package eu.mshade.enderframe.mojang.chat;


import java.util.Map;
import java.util.Objects;

public class TextComponentEntry {

    protected String text;
    protected ChatColor chatColor;
    protected boolean bold = false;
    protected boolean italic = false;
    protected boolean strikethrough = false;
    protected boolean obfuscated = false;
    protected boolean underlined;
    protected TextClickEvent clickEvent;
    protected TextHoverEvent hoverEvent;

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

    public ChatColor getChatColor() {
        return chatColor;
    }

    public TextComponentEntry withColor(ChatColor chatColor) {
        this.chatColor = chatColor;
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

    public TextComponentEntry withHoverEvent(TextHoverEvent hoverEvent) {
        this.hoverEvent = hoverEvent;
        return this;
    }

    public TextHoverEvent getHoverEvent() {
        return hoverEvent;
    }

    public boolean isUnderlined() {
        return underlined;
    }

    public TextComponentEntry withUnderlined(boolean underlined) {
        this.underlined = underlined;
        return this;
    }

    public String toLegacyText(){
        StringBuilder stringBuilder = new StringBuilder();
        if (getChatColor() != null) stringBuilder.append(getChatColor());
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
                ", color='" + chatColor + '\'' +
                ", bold=" + bold +
                ", italic=" + italic +
                ", strikethrough=" + strikethrough +
                ", obfuscated=" + obfuscated +
                ", underlined=" + underlined +
                ", clickEvent=" + clickEvent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextComponentEntry that = (TextComponentEntry) o;
        return bold == that.bold && italic == that.italic && strikethrough == that.strikethrough && obfuscated == that.obfuscated && underlined == that.underlined && Objects.equals(text, that.text) && Objects.equals(chatColor, that.chatColor) && Objects.equals(clickEvent, that.clickEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, chatColor, bold, italic, strikethrough, obfuscated, underlined, clickEvent);
    }
}

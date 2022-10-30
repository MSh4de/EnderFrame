package eu.mshade.enderframe.mojang.chat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class TextComponent extends TextComponentEntry {

    private List<TextComponentEntry> extra = new ArrayList<>();

    private TextComponent() {
        super("");
    }

    private TextComponent(String text) {
        super(text);
    }

    public static TextComponent of(String text){
        return new TextComponent(text);
    }

    public void addExtras(TextComponentEntry... textComponentEntries){
        extra.addAll(Arrays.asList(textComponentEntries));
    }

    public List<TextComponentEntry> getExtra() {
        return extra;
    }

    public TextComponent withColor(ChatColor chatColor) {
        return (TextComponent) super.withColor(chatColor);
    }

    public TextComponent withBold(boolean bold) {
        return (TextComponent) super.withBold(bold);
    }

    public TextComponent withItalic(boolean italic) {
        return (TextComponent) super.withItalic(italic);
    }

    public TextComponent withStrikethrough(boolean strikethrough) {
        return (TextComponent) super.withStrikethrough(strikethrough);
    }

    public TextComponent withObfuscated(boolean obfuscated) {
        return (TextComponent) super.withObfuscated(obfuscated);
    }

    public TextComponent withClickEvent(TextClickEvent clickEvent) {
        return (TextComponent) super.withClickEvent(clickEvent);
    }

    public TextComponent withUnderlined(boolean underlined) {
        return (TextComponent) super.withUnderlined(underlined);
    }

    public String toLegacyText(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toLegacyText());
        extra.forEach(textComponentEntry -> {
            stringBuilder.append(textComponentEntry.toLegacyText());
        });
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "TextComponent{" +
                "extra=" + extra +
                ", text='" + text + '\'' +
                ", chatColor=" + chatColor +
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
        if (!super.equals(o)) return false;
        TextComponent that = (TextComponent) o;
        return Objects.equals(extra, that.extra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), extra);
    }
}

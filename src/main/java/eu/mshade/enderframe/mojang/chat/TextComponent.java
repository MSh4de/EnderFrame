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
                "text='" + this.getText() + '\'' +
                ", color='" + this.getChatColor() + '\'' +
                ", bold=" + this.isBold() +
                ", italic=" + this.isItalic() +
                ", strikethrough=" + this.isStrikethrough() +
                ", obfuscated=" + this.isObfuscated() +
                ", clickEvent=" + this.getClickEvent() +
                "extra=" + extra +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextComponent that = (TextComponent) o;
        return Objects.equals(extra, that.extra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extra);
    }
}

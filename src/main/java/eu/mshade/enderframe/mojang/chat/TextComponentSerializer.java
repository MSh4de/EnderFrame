package eu.mshade.enderframe.mojang.chat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class TextComponentSerializer extends JsonSerializer<TextComponentEntry> {
    @Override
    public void serialize(TextComponentEntry value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("text", value.getText());

        if (!value.getColor().equals(ChatColor.WHITE.getName())) gen.writeStringField("color", value.getColor());
        if (value.isBold()) gen.writeBooleanField("bold", true);
        if (value.isItalic()) gen.writeBooleanField("italic", true);
        if (value.isStrikethrough()) gen.writeBooleanField("strikethrough", true);
        if (value.isObfuscated()) gen.writeBooleanField("obfuscated", true);

        if (value.getClickEvent() != null) serializers.defaultSerializeField("clickEvent", value.getClickEvent(), gen);

        if (value instanceof TextComponent) {
            if (!((TextComponent) value).getExtra().isEmpty()) serializers.defaultSerializeField("extra", value.getClickEvent(), gen);
        }

        gen.writeEndObject();
    }
}

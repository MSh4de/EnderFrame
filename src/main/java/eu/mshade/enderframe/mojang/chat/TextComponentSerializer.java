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

        if (value.getChatColor() != null) gen.writeStringField("color", value.getChatColor().getName());
        if (value.isBold()) gen.writeBooleanField("bold", true);
        if (value.isItalic()) gen.writeBooleanField("italic", true);
        if (value.isStrikethrough()) gen.writeBooleanField("strikethrough", true);
        if (value.isUnderlined()) gen.writeBooleanField("underlined", true);
        if (value.isObfuscated()) gen.writeBooleanField("obfuscated", true);

        if (value.getClickEvent() != null) serializers.defaultSerializeField("clickEvent", value.getClickEvent(), gen);
        if (value.getHoverEvent() != null) serializers.defaultSerializeField("hoverEvent", value.getHoverEvent(), gen);

        if (value instanceof TextComponent textComponent) {
            if (!textComponent.getExtra().isEmpty()) {
                serializers.defaultSerializeField("extra", textComponent.getExtra(), gen);
            }
        }

        gen.writeEndObject();
    }
}

package eu.mshade.enderframe.mojang.chat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class TextHoverEventSerializer extends JsonSerializer<TextHoverEvent> {
    @Override
    public void serialize(TextHoverEvent value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("value", value.getValue());
        gen.writeStringField("action", value.getType().toString().toLowerCase());
        gen.writeEndObject();
    }
}

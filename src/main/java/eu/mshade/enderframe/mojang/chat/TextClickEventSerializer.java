package eu.mshade.enderframe.mojang.chat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class TextClickEventSerializer extends JsonSerializer<TextClickEvent> {
    @Override
    public void serialize(TextClickEvent value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("value", value.getValue());
        gen.writeStringField("action", value.getAction().toString().toLowerCase());
        gen.writeEndObject();
    }
}

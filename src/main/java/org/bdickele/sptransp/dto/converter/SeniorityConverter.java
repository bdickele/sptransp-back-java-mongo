package org.bdickele.sptransp.dto.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bdickele.sptransp.domain.Seniority;

import java.io.IOException;

/**
 * Created by Bertrand DICKELE
 */
public class SeniorityConverter {

    public static class SenioritySerializer extends JsonSerializer<Seniority> {

        @Override
        public void serialize(Seniority seniority, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException, JsonProcessingException {
            jsonGenerator.writeString(seniority.getValue().toString());
        }
    }

    public static class SeniorityDeserializer extends JsonDeserializer<Seniority> {

        @Override
        public Seniority deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            try {
                return Seniority.of(Integer.getInteger(jsonParser.getText()));
            } catch (Exception e) {
                return Seniority.of(0);
            }
        }
    }
}

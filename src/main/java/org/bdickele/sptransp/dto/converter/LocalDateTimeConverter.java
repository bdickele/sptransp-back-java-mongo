package org.bdickele.sptransp.dto.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Bertrand DICKELE
 */
public final class LocalDateTimeConverter {

    public final static String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);


    public static class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

        @Override
        public void serialize(LocalDateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException, JsonProcessingException {
            jsonGenerator.writeString(dateTime.format(DATE_TIME_FORMATTER));
        }
    }

    public static class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

        @Override
        public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return LocalDateTime.parse(jsonParser.getText(), DATE_TIME_FORMATTER);
        }
    }
}

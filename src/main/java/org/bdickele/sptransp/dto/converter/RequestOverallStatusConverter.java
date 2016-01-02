package org.bdickele.sptransp.dto.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bdickele.sptransp.domain.RequestOverallStatus;

import java.io.IOException;

/**
 * Created by Bertrand DICKELE
 */
public class RequestOverallStatusConverter {

    public static class RequestOverallStatusSerializer extends JsonSerializer<RequestOverallStatus> {

        @Override
        public void serialize(RequestOverallStatus overallStatus, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException, JsonProcessingException {
            jsonGenerator.writeString(overallStatus.getCode());
        }
    }

    public static class RequestOverallStatusDeserializer extends JsonDeserializer<RequestOverallStatus> {

        @Override
        public RequestOverallStatus deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return RequestOverallStatus.getByCode(jsonParser.getText());
        }
    }
}

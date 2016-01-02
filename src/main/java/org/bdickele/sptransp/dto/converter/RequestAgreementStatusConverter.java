package org.bdickele.sptransp.dto.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bdickele.sptransp.domain.RequestAgreementStatus;

import java.io.IOException;

/**
 * Created by Bertrand DICKELE
 */
public class RequestAgreementStatusConverter {

    public static class RequestAgreementStatusSerializer extends JsonSerializer<RequestAgreementStatus> {

        @Override
        public void serialize(RequestAgreementStatus agreementStatus, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException, JsonProcessingException {
            jsonGenerator.writeString(agreementStatus.getCode());
        }
    }

    public static class RequestAgreementStatusDeserializer extends JsonDeserializer<RequestAgreementStatus> {

        @Override
        public RequestAgreementStatus deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return RequestAgreementStatus.getByCode(jsonParser.getText());
        }
    }
}

package org.lionpooh.spring.eventlistener.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.lionpooh.spring.eventlistener.vo.NovaInstance;

import java.io.IOException;

public class NovaInstanceEventDecerializer extends JsonDeserializer<NovaInstance> {

    @Override
    public NovaInstance deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        NovaInstance novaInstance = new NovaInstance();
        JsonNode novaInstanceNode = jsonParser.getCodec().readTree(jsonParser);
        String eventType = findJsonPathValue(novaInstanceNode, "event_type");


        return novaInstance;
    }

    private String findJsonPathValue(JsonNode jsonNode, String field) {
        String value = jsonNode.findPath(field).asText();
        if(value.equals("null")) return null;
        return value;
    }


}

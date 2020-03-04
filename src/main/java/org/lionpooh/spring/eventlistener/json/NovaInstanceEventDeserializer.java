package org.lionpooh.spring.eventlistener.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.lionpooh.spring.eventlistener.constant.JsonField;
import org.lionpooh.spring.eventlistener.vo.NovaInstance;

import java.io.IOException;

public class NovaInstanceEventDeserializer extends JsonDeserializer<NovaInstance> {

    @Override
    public NovaInstance deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        NovaInstance novaInstance = new NovaInstance();
        JsonNode novaInstanceNode = jsonParser.getCodec().readTree(jsonParser);
        String eventType = findJsonPathValue(novaInstanceNode, JsonField.OpenstackCommon.EVENT_TYPE.getField());
        String instanceName = findJsonPathValue(novaInstanceNode, JsonField.NovaInstance.DISPLAY_NAME.getField());
        String instanceUUID = findJsonPathValue(novaInstanceNode, JsonField.NovaInstance.UUID.getField());
        String instanceState = findJsonPathValue(novaInstanceNode, JsonField.NovaInstance.STATE.getField());
        String instanceTaskState = findJsonPathValue(novaInstanceNode, JsonField.NovaInstance.TASK_STATE.getField());
        String instancePowerState = findJsonPathValue(novaInstanceNode, JsonField.NovaInstance.POWER_STATE.getField());

        novaInstance.setEventType(eventType);
        novaInstance.setInstanceName(instanceName);
        novaInstance.setInstanceUUID(instanceUUID);
        novaInstance.setInstanceState(instanceState);
        novaInstance.setInstanceTaskState(instanceTaskState);
        novaInstance.setInstancePowerState(instancePowerState);

        return novaInstance;
    }

    private String findJsonPathValue(JsonNode jsonNode, String field) {
        String value = jsonNode.findPath(field).asText();
        if(value.equals("null")) return null;
        return value;
    }


}

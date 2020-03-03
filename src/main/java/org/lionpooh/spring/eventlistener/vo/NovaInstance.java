package org.lionpooh.spring.eventlistener.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.lionpooh.spring.eventlistener.json.NovaInstanceEventDecerializer;

@Data
@JsonDeserialize(using = NovaInstanceEventDecerializer.class)
public class NovaInstance {
    private String eventType;
    private String instanceName;
    private String instanceUUID;
    private String instanceState;
    private String instanceTaskState;
    private String instancePowerState;
}

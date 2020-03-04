package org.lionpooh.spring.eventlistener.vo;

import lombok.Data;
import org.lionpooh.spring.eventlistener.constant.EventType;
import org.lionpooh.spring.eventlistener.constant.Service;
import org.lionpooh.spring.eventlistener.constant.Type;

@Data
public class EventMessage {
    private Service service;
    private Type type;
    private EventType eventType;
    private String msgJson;

    public String getServiceTypeName() {
        return service.name() + type.name();
    }

    public String getEventTypeName() {
        return eventType.getEventType();
    }

}

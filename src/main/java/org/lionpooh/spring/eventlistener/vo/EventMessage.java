package org.lionpooh.spring.eventlistener.vo;

import lombok.Data;
import org.lionpooh.spring.eventlistener.constant.Service;
import org.lionpooh.spring.eventlistener.constant.Type;

@Data
public class EventMessage {
    private Service service;
    private Type type;
    private String msgJson;

    public String getServiceType() {
        return service.name() + type.name();
    }
}

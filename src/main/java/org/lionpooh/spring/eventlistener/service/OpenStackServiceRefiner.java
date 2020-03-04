package org.lionpooh.spring.eventlistener.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.lionpooh.spring.eventlistener.annotation.EventRefiner;
import org.lionpooh.spring.eventlistener.constant.EventType;
import org.lionpooh.spring.eventlistener.constant.Service;
import org.lionpooh.spring.eventlistener.constant.Type;
import org.lionpooh.spring.eventlistener.exception.EventListenerException;
import org.lionpooh.spring.eventlistener.vo.EventMessage;
import org.lionpooh.spring.eventlistener.vo.NovaInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Slf4j
@Component
public class OpenStackServiceRefiner implements ServiceRefiner {

//    private final Map<String, Method> eventRefinerMap;

    private final ObjectMapper objectMapper;

    @Autowired
    public OpenStackServiceRefiner(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @EventRefiner(service = Service.NOVA, type = Type.INSTANCE, eventType = EventType.INSTANCE_EVENT_PREFIX)
    public void refineNovaInstanceEvent(String msgJson) throws Exception {
        NovaInstance novaInstance = objectMapper.readValue(msgJson, NovaInstance.class);
        //insert elasticsearch, mongodb, mysql
    }

    @EventRefiner(service = Service.NOVA, type = Type.INSTANCE, eventType = EventType.INSTANCE_CREATE_START)
    public void refineNovaInstanceCreateEvent(String msgJson) {

    }

    @EventRefiner(service = Service.NOVA, type = Type.INSTANCE, eventType = EventType.INSTANCE_CREATE_END)
    public void refineNovaInstanceStopEvent(String msgJson) {

    }

    @Override
    public List<EventType> refineEvent(EventMessage eventMessage) throws EventListenerException {

        List<EventType> eventTypeList = new ArrayList<>();

        if (eventMessage.getEventType() == null) {
            throw new EventListenerException("no valid event type in event message");
        }

        Class refinerClazz = OpenStackServiceRefiner.class;
        Method[] methodArray = refinerClazz.getDeclaredMethods();
        for (Method refinerMethod : methodArray) {
            if(refinerMethod.isAnnotationPresent(EventRefiner.class))   {
                EventRefiner eventRefiner = refinerMethod.getAnnotation(EventRefiner.class);
                String eventTypeName = eventRefiner.eventType().getEventType();
                //annotation + reflection
                if (Pattern.matches(eventTypeName, eventMessage.getEventTypeName())) {
                    try {
                        refinerMethod.invoke(this, eventMessage.getMsgJson());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    eventTypeList.add(eventRefiner.eventType());
                }
            }
        }

        return eventTypeList;
    }

}

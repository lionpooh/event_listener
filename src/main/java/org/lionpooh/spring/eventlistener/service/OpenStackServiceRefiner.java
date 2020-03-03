package org.lionpooh.spring.eventlistener.service;

import org.lionpooh.spring.eventlistener.annotation.ServiceType;
import org.lionpooh.spring.eventlistener.constant.Service;
import org.lionpooh.spring.eventlistener.constant.Type;
import org.lionpooh.spring.eventlistener.exception.EventListenerException;
import org.lionpooh.spring.eventlistener.vo.EventMessage;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class OpenStackServiceRefiner implements ServiceRefiner {

    private final Map<String, Method> eventRefinerMap;

    public OpenStackServiceRefiner() {
        this.eventRefinerMap = new HashMap<>();

        Class refinerClazz = OpenStackServiceRefiner.class;
        Method[] methodArray = refinerClazz.getDeclaredMethods();
        for (Method m : methodArray) {
            if (m.isAnnotationPresent(ServiceType.class)) {
                ServiceType annotation = m.getAnnotation(ServiceType.class);
                String service = annotation.service().name();
                String type = annotation.type().name();
                String serviceType = service + type;
                eventRefinerMap.put(serviceType, eventRefinerMap.getOrDefault(serviceType, m));
            }
        }
    }

    @ServiceType(service = Service.NOVA, type = Type.INSTANCE)
    public void refineNovaInstanceEvent(String msgJson) {

    }

    @ServiceType(service = Service.NOVA, type = Type.COMPUTE)
    public void refineNovaComputeEvent(String msgJson) {

    }

//    @ServiceType(service = "cinder", type = "volume")
//    public void refineCinderVolumeEvent(String eventJson) {
//
//    }

    @Override
    public void refineEvent(EventMessage eventMessage) throws EventListenerException {
        if (eventMessage.getService() == null || eventMessage.getType() == null) {
            throw new EventListenerException("no valid event message service or type!");
        }

        String serviceType = eventMessage.getServiceType();
        Method refineMethod = eventRefinerMap.get(serviceType);
        try {
            refineMethod.invoke(this, eventMessage.getMsgJson());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

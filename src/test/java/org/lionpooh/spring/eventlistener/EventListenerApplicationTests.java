package org.lionpooh.spring.eventlistener;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lionpooh.spring.eventlistener.annotation.ServiceType;
import org.lionpooh.spring.eventlistener.constant.Service;
import org.lionpooh.spring.eventlistener.constant.Type;
import org.lionpooh.spring.eventlistener.service.OpenStackServiceRefiner;
import org.lionpooh.spring.eventlistener.vo.EventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import sun.tools.java.ClassPath;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class EventListenerApplicationTests {

    @Autowired
    private OpenStackServiceRefiner openStackServiceRefiner;

    @BeforeEach
    public void testInitialize() {
//        Class refinerClazz = OpenStackServiceRefiner.class;
//        Method[] methodArray = refinerClazz.getDeclaredMethods();
//        for (Method m : methodArray) {
//            if (m.isAnnotationPresent(ServiceType.class)) {
//                ServiceType annotation = m.getAnnotation(ServiceType.class);
//                Service service = annotation.service();
//                Type type = annotation.type();
//                String serviceType = service.name() + type.name();
//                methodMap.put(serviceType, methodMap.getOrDefault(serviceType, m));
//            }
//        }
    }

    @Test
    void testNovaRefiner() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource cpr = new ClassPathResource("json/instance_create_start.json");
        JsonNode instanceNode = objectMapper.readTree(cpr.getInputStream());
        String json = instanceNode.toPrettyString();
        EventMessage eventMessage = new EventMessage();
//        openStackServiceRefiner.refineEvent();
    }


//    @TestConfiguration
//    static class EventListenerConfig {
//
//        @Bean
//        public OpenStackServiceRefiner openStackServiceRefiner() {
//            return new OpenStackServiceRefiner();
//        }
//    }

}

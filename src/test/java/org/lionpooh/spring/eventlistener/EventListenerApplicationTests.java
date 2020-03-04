package org.lionpooh.spring.eventlistener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lionpooh.spring.eventlistener.constant.EventType;
import org.lionpooh.spring.eventlistener.service.OpenStackServiceRefiner;
import org.lionpooh.spring.eventlistener.vo.EventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventListenerApplicationTests {

    @Autowired
    private OpenStackServiceRefiner openStackServiceRefiner;

    @BeforeEach
    public void testInitialize() {

    }

    @Test
    void novaInstanceEventRefinerTest() throws Exception {
        EventMessage eventMessage = new EventMessage();
        eventMessage.setEventType(EventType.INSTANCE_CREATE_START);
        openStackServiceRefiner.refineEvent(eventMessage);

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

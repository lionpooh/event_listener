package org.lionpooh.spring.eventlistener.eventlistener;

import org.lionpooh.spring.eventlistener.service.OpenStackServiceRefiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NovaEventListener {

    private final OpenStackServiceRefiner openStackServiceRefiner;

    @Autowired
    public NovaEventListener(OpenStackServiceRefiner openStackServiceRefiner) {
        this.openStackServiceRefiner = openStackServiceRefiner;
    }

    public void novaInstanceEvent() {

    }
}

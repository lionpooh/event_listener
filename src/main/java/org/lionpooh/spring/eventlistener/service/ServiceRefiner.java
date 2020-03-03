package org.lionpooh.spring.eventlistener.service;

import org.lionpooh.spring.eventlistener.exception.EventListenerException;
import org.lionpooh.spring.eventlistener.vo.EventMessage;

public interface ServiceRefiner {
    public void refineEvent(EventMessage eventMessage) throws EventListenerException;
}

package org.lionpooh.spring.eventlistener.service;

import org.lionpooh.spring.eventlistener.exception.EventListenerException;
import org.lionpooh.spring.eventlistener.vo.EventMessage;

public interface ServiceRefiner <T> {
    //리턴 타입에 대해서 고민 -> 테스트 검증시
    T refineEvent(EventMessage eventMessage) throws EventListenerException;
}

package org.lionpooh.spring.eventlistener.constant;

public enum EventType {
    DEFAULT(""),
    INSTANCE_EVENT_PREFIX("instance.*"),
    INSTANCE_CREATE_START("instance.create.start"),
    INSTANCE_CREATE_END("instance.create.end");
    private String eventType;
    EventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}

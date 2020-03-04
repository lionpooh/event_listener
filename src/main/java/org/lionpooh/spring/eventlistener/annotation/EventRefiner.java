package org.lionpooh.spring.eventlistener.annotation;

import org.lionpooh.spring.eventlistener.constant.EventType;
import org.lionpooh.spring.eventlistener.constant.Service;
import org.lionpooh.spring.eventlistener.constant.Type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventRefiner {
    Service service();
    Type type();
    EventType eventType() default EventType.DEFAULT;

}

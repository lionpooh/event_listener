package org.lionpooh.spring.eventlistener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventListenerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EventListenerApplication.class, args);
    }

    public void run(String... args) throws Exception {
        
    }
}

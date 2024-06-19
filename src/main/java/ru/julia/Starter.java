package ru.julia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.julia.servicelayer.dbinitiator.DatabaseInitiator;

@Component
public class Starter {
    @Autowired
    private DatabaseInitiator databaseInitiator;
    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        databaseInitiator.initialize();
    }
}

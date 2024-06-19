package ru.julia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.servicelayer.dbinitiator.DatabaseInitiator;

@Component
public class Starter {
    @Autowired
    private DatabaseInitiator databaseInitiator;
    public void start()  {
        //databaseInitiator.initialize();
    }
}

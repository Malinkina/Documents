package ru.julia.servicelayer.dbinitiator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.servicelayer.dbinitiator.dbfilling.TableFiller;

import java.util.List;

@Component
public class DatabaseInitiator {
    @Autowired
    private List<TableFiller> tableFillers;
    public void initialize() {
        tableFillers.forEach(TableFiller::fill);
    }
}

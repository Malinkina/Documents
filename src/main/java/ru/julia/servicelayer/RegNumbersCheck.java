package ru.julia.servicelayer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.julia.exception.DocumentExistsException;
import ru.julia.orm.jpamodel.DocumentJpa;
import ru.julia.orm.repository.DocumentRepository;

/**
 * Класс-хранилище регистрационных номеров
 */
@Service
@AllArgsConstructor
public class RegNumbersCheck {
    private final DocumentRepository repository;

    public void check(String regNumber) throws DocumentExistsException {
        if (exists(regNumber)) {
            throw new DocumentExistsException("Документ с таким RegNumber уже существует");
        }
    }

    private boolean exists(String regNumber) {
        DocumentJpa documentJpa = repository.findByRegNumber(regNumber);
        return documentJpa != null;
    }
}
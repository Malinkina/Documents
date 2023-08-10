package ru.julia.factories;

import org.apache.commons.lang3.RandomStringUtils;
import ru.julia.documents.Document;
import ru.julia.representatives.InternalRepresentatives;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DocumentFactory {
    public abstract Document create();
}

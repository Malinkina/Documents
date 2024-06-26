package ru.julia.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.document.Document;
import ru.julia.infogenerator.DocumentInfoGenerator;

@Component
public abstract class AbstractDocumentFactory<T extends Document, B extends Document.DocumentBuilder<T, B>> implements DocumentFactory<T> {
    @Autowired
    private DocumentInfoGenerator documentInfoGenerator;
    protected abstract B createBuilder();
    protected abstract void fill(B builder);
    public T create() {
        B builder = createBuilder();
        builder
                .documentId(documentInfoGenerator.generateId())
                .name(documentInfoGenerator.generateName())
                .text(documentInfoGenerator.generateText())
                .regNumber(documentInfoGenerator.generateRegNumber())
                .regDate(documentInfoGenerator.generateRegDate())
                .author(documentInfoGenerator.generateAuthor());
        fill(builder);
        return builder.build();
    }
}

package ru.julia.factories;

import ru.julia.builders.TaskDocumentBuilder;
import ru.julia.documents.TaskDocument;

public class TaskDocumentFactory implements DocumentFactory {
    TaskDocumentBuilder builder = new TaskDocumentBuilder();
    @Override
    public TaskDocument create() {
        TaskDocument taskDocument = new TaskDocument();
        builder.build(taskDocument);
        return taskDocument;
    }
}

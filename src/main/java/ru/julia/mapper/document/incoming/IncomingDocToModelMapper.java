package ru.julia.mapper.document.incoming;

import ru.julia.document.IncomingDocument;
import ru.julia.servicelayer.model.IncomingDocModel;

public interface IncomingDocToModelMapper {
    IncomingDocModel toModel(IncomingDocument incomingDocument);
}

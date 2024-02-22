package ru.julia.service.mapper;

import org.springframework.stereotype.Component;
import ru.julia.document.Document;
import ru.julia.orm.jpamodel.DocumentJPA;
import ru.julia.service.modelforservice.DocumentModel;
@Component
public class DocumentMapper {
    public DocumentModel documentToDocumentModel(Document document) {
        DocumentModel documentModel = new DocumentModel();
        documentModel.setId(document.getId());
        documentModel.setDocumentId(document.getDocumentId());
        documentModel.setText(document.getText());
        documentModel.setName(document.getName());
        documentModel.setRegDate(document.getRegDate());
        documentModel.setRegNumber(document.getRegNumber());
        documentModel.setAuthor(document.getAuthor());
        return documentModel;
    }
    public DocumentJPA documentModelToDocumentJPA(DocumentModel documentModel) {
        DocumentJPA documentJPA = new DocumentJPA();
        documentJPA.setId(documentModel.getId());
        documentJPA.setDocumentId(documentModel.getDocumentId());
        documentJPA.setText(documentModel.getText());
        documentJPA.setName(documentModel.getName());
        documentJPA.setRegDate(documentModel.getRegDate());
        documentJPA.setRegNumber(documentModel.getRegNumber());
        return documentJPA;
    }
}

/*
package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dao.DocumentDAO;
import ru.julia.orm.domain.JPADocument;
import ru.julia.dto.DocumentDTO;

import java.util.Comparator;
import java.util.List;

@Component
public class DocumentService {
    @Autowired
    private DocumentDAO documentDAO;

    public void create(JPADocument document) {
        documentDAO.create(document);
    }

    public DocumentDTO read(String id) {
        return documentDAO.read(id);
    }

    public List<DocumentDTO> readAll() {
        List<DocumentDTO> docList = documentDAO.readAll();
        docList.sort(Comparator.comparing(DocumentDTO::getRegDate).reversed());
        return docList;
    }

    public void update(String id, JPADocument document) {
        documentDAO.update(id, document);
    }
}
*/

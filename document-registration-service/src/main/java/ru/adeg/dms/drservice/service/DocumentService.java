package ru.adeg.dms.drservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.adeg.dms.drservice.entity.DocumentEntity;
import ru.adeg.dms.drservice.repository.DocumentRepository;

public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public DocumentEntity addDocument (DocumentEntity document) {
        return documentRepository.save(document);
    }
}

package ru.adeg.dms.drservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adeg.dms.drservice.entity.DocumentMetadata;
import ru.adeg.dms.drservice.repository.DocumentMetadataRepository;

@Service
public class DocumentMetadataService {
    @Autowired
    private DocumentMetadataRepository documentRepository;

    public DocumentMetadata addDocument (DocumentMetadata document) {
        return documentRepository.save(document);
    }

}

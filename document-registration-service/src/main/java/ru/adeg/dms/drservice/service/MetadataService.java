package ru.adeg.dms.drservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.adeg.dms.drservice.entity.Metadata;
import ru.adeg.dms.drservice.repository.MetadataRepository;

public class MetadataService {
    @Autowired
    private MetadataRepository documentRepository;

    public Metadata addDocument (Metadata document) {
        return documentRepository.save(document);
    }
}

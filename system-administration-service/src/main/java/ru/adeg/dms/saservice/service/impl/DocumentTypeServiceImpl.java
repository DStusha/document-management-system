package ru.adeg.dms.saservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adeg.dms.saservice.entity.DocumentType;
import ru.adeg.dms.saservice.repository.DocumentTypeRepository;
import ru.adeg.dms.saservice.service.DocumentTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public DocumentType addDocumentType(DocumentType documentType) {
        return documentTypeRepository.saveAndFlush(documentType);
    }

    public void delete(long id) {
        documentTypeRepository.deleteById(id);
    }

    public List<DocumentType> getAll() {
        return documentTypeRepository.findAll();
    }

    public Optional<DocumentType> getDocumentTypeByName(String name) {
        return documentTypeRepository.findByName(name);
    }

    public Optional<DocumentType> getDocumentTypeById(Long id) {
        return documentTypeRepository.findById(id);
    }
}

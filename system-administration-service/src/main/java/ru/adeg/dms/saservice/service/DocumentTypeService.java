package ru.adeg.dms.saservice.service;

import ru.adeg.dms.saservice.entity.DocumentType;

import java.util.List;
import java.util.Optional;

public interface DocumentTypeService {
    DocumentType addDocumentType(DocumentType documentType);
    void delete(long id);
    List<DocumentType> getAll();
    Optional<DocumentType> getDocumentTypeByName(String name);
    Optional<DocumentType> getDocumentTypeById(Long id);
}

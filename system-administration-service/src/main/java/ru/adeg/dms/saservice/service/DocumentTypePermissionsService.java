package ru.adeg.dms.saservice.service;

import ru.adeg.dms.saservice.entity.DocumentTypePermissions;

import java.util.List;
import java.util.Optional;

public interface DocumentTypePermissionsService {
    DocumentTypePermissions addDocumentTypePermissions(DocumentTypePermissions documentTypePermissions);
    void delete(long id);
    List<DocumentTypePermissions> getAll();
    Optional<DocumentTypePermissions> getDocumentTypePermissionsById(Long id);
}

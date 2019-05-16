package ru.adeg.dms.saservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adeg.dms.saservice.entity.DocumentTypePermissions;
import ru.adeg.dms.saservice.repository.DocumentTypePermissionsRepository;
import ru.adeg.dms.saservice.service.DocumentTypePermissionsService;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypePermissionsServiceImpl implements DocumentTypePermissionsService {

    @Autowired
    private DocumentTypePermissionsRepository documentTypePermissionsRepository;

    public DocumentTypePermissions addDocumentTypePermissions(DocumentTypePermissions documentTypePermissions) {
        return documentTypePermissionsRepository.saveAndFlush(documentTypePermissions);
    }

    public void delete(long id) {
        documentTypePermissionsRepository.deleteById(id);
    }

    public List<DocumentTypePermissions> getAll() {
        return documentTypePermissionsRepository.findAll();
    }

    public Optional<DocumentTypePermissions> getDocumentTypePermissionsById(Long id) {
        return documentTypePermissionsRepository.findById(id);
    }
}

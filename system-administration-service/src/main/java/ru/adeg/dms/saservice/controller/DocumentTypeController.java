package ru.adeg.dms.saservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.adeg.dms.saservice.entity.DocumentType;
import ru.adeg.dms.saservice.service.DocumentTypeService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documentTypes")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService documentTypeService;

    @GetMapping
    public ResponseEntity<List<DocumentType>> allDocumentTypes() {
        List<DocumentType> documentTypes = documentTypeService.getAll();
        return ResponseEntity.ok().body(documentTypes);
    }

    @GetMapping(value = "/{documentTypeId}")
    public ResponseEntity<DocumentType> getDocumentType(@PathVariable("documentTypeId") Long documentTypeId)
            throws EntityNotFoundException {
        Optional<DocumentType> DocumentType = documentTypeService.getDocumentTypeById(documentTypeId);
        if (!DocumentType.isPresent())
            throw new EntityNotFoundException("id-" + documentTypeId);
        return ResponseEntity.ok().body(DocumentType.get());
    }
    @PostMapping
    public ResponseEntity<DocumentType> createDocumentType(@RequestBody @Valid DocumentType DocumentType) {
        DocumentType p = documentTypeService.addDocumentType(DocumentType);
        return ResponseEntity.status(201).body(p);
    }
    @PutMapping(value = "/{documentTypeId}")
    public ResponseEntity<DocumentType> updateDocumentType(@RequestBody @Valid DocumentType DocumentType,
                                                           @PathVariable("documentTypeId") Long documentTypeId) throws EntityNotFoundException {
        Optional<DocumentType> p = documentTypeService.getDocumentTypeById(documentTypeId);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + documentTypeId);
        return ResponseEntity.ok().body(documentTypeService.addDocumentType(DocumentType));
    }
    @DeleteMapping(value = "/{documentTypeId}")
    public ResponseEntity<DocumentType> deleteDocumentType(@PathVariable("documentTypeId") Long documentTypeId)
            throws EntityNotFoundException {
        Optional<DocumentType> p = documentTypeService.getDocumentTypeById(documentTypeId);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + documentTypeId);
        documentTypeService.getDocumentTypeById(documentTypeId);
        return ResponseEntity.ok().body(p.get());
    }

}

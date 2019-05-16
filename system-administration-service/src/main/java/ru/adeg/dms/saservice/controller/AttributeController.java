package ru.adeg.dms.saservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.adeg.dms.saservice.entity.Attribute;
import ru.adeg.dms.saservice.service.AttributeService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @GetMapping
    public ResponseEntity<List<Attribute>> allAttributes() {
        List<Attribute> attributes = attributeService.getAll();
        return ResponseEntity.ok().body(attributes);
    }

    @GetMapping(value = "/{attributeId}")
    public ResponseEntity<Attribute> getAttribute(@PathVariable("attributeId") Long attributeId)
            throws EntityNotFoundException {
        Optional<Attribute> Attribute = attributeService.getAttributeById(attributeId);
        if (!Attribute.isPresent())
            throw new EntityNotFoundException("id-" + attributeId);
        return ResponseEntity.ok().body(Attribute.get());
    }

    @PostMapping
    public ResponseEntity<Attribute> createAttribute(@RequestBody @Valid Attribute Attribute) {
        Attribute p = attributeService.addAttribute(Attribute);
        return ResponseEntity.status(201).body(p);
    }

    @PutMapping(value = "/{attributeId}")
    public ResponseEntity<Attribute> updateAttribute(@RequestBody @Valid Attribute Attribute,
                                                     @PathVariable("attributeId") Long attributeId) throws EntityNotFoundException {
        Optional<Attribute> p = attributeService.getAttributeById(attributeId);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + attributeId);
        return ResponseEntity.ok().body(attributeService.addAttribute(Attribute));
    }

    @DeleteMapping(value = "/{attributeId}")
    public ResponseEntity<Attribute> deleteAttribute(@PathVariable("attributeId") Long attributeId)
            throws EntityNotFoundException {
        Optional<Attribute> p = attributeService.getAttributeById(attributeId);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + attributeId);
        attributeService.getAttributeById(attributeId);
        return ResponseEntity.ok().body(p.get());
    }
}

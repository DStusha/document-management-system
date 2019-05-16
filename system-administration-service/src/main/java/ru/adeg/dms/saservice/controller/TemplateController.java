package ru.adeg.dms.saservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.adeg.dms.saservice.entity.Template;
import ru.adeg.dms.saservice.service.TemplateService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/templates")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @GetMapping
    public ResponseEntity<List<Template>> allTemplates() {
        List<Template> templates = templateService.getAll();
        return ResponseEntity.ok().body(templates);
    }

    @GetMapping(value = "/{templateId}")
    public ResponseEntity<Template> getTemplate(@PathVariable("templateId") Long templateId)
            throws EntityNotFoundException {
        Optional<Template> Template = templateService.getTemplateById(templateId);
        if (!Template.isPresent())
            throw new EntityNotFoundException("id-" + templateId);
        return ResponseEntity.ok().body(Template.get());
    }
    @PostMapping
    public ResponseEntity<Template> createTemplate(@RequestBody @Valid Template Template) {
        Template p = templateService.addTemplate(Template);
        return ResponseEntity.status(201).body(p);
    }
    @PutMapping(value = "/{templateId}")
    public ResponseEntity<Template> updateTemplate(@RequestBody @Valid Template Template,
                                                   @PathVariable("templateId") Long templateId) throws EntityNotFoundException {
        Optional<Template> p = templateService.getTemplateById(templateId);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + templateId);
        return ResponseEntity.ok().body(templateService.addTemplate(Template));
    }
    @DeleteMapping(value = "/{templateId}")
    public ResponseEntity<Template> deleteTemplate(@PathVariable("templateId") Long templateId)
            throws EntityNotFoundException {
        Optional<Template> p = templateService.getTemplateById(templateId);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + templateId);
        templateService.delete(templateId);
        return ResponseEntity.ok().body(p.get());
    }
}


package ru.adeg.dms.saservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adeg.dms.saservice.entity.Template;
import ru.adeg.dms.saservice.repository.TemplateRepository;
import ru.adeg.dms.saservice.service.TemplateService;

import java.util.List;
import java.util.Optional;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    public Template addTemplate(Template template) {
        return templateRepository.saveAndFlush(template);
    }

    public void delete(long id) {
        templateRepository.deleteById(id);
    }

    public List<Template> getAll() {
        return templateRepository.findAll();
    }

    public Optional<Template> getTemplateByName(String name) {
        return templateRepository.findByName(name);
    }

    public Optional<Template> getTemplateById(Long id) {
        return templateRepository.findById(id);
    }
}

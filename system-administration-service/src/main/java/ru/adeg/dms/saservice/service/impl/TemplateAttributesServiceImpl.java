package ru.adeg.dms.saservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adeg.dms.saservice.entity.TemplateAttributes;
import ru.adeg.dms.saservice.repository.TemplateAttributesRepository;
import ru.adeg.dms.saservice.service.TemplateAttributesService;

import java.util.List;
import java.util.Optional;

@Service
public class TemplateAttributesServiceImpl implements TemplateAttributesService {
    @Autowired
    private TemplateAttributesRepository templateAttributesRepository;

    public TemplateAttributes addTemplateAttributes(TemplateAttributes templateAttributes) {
        return templateAttributesRepository.saveAndFlush(templateAttributes);
    }

    public void delete(long id) {
        templateAttributesRepository.deleteById(id);
    }

    public List<TemplateAttributes> getAll() {
        return templateAttributesRepository.findAll();
    }

    public Optional<TemplateAttributes> getTemplateAttributesById(Long id) {
        return templateAttributesRepository.findById(id);
    }
}

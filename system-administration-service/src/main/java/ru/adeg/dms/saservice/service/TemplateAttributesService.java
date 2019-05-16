package ru.adeg.dms.saservice.service;

import ru.adeg.dms.saservice.entity.TemplateAttributes;

import java.util.List;
import java.util.Optional;

public interface TemplateAttributesService {
    TemplateAttributes addTemplateAttributes(TemplateAttributes templateAttributes);
    void delete(long id);
    List<TemplateAttributes> getAll();
    Optional<TemplateAttributes> getTemplateAttributesById(Long id);
}

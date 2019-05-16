package ru.adeg.dms.saservice.service;

import ru.adeg.dms.saservice.entity.Template;

import java.util.List;
import java.util.Optional;

public interface TemplateService {
    Template addTemplate(Template template);
    void delete(long id);
    List<Template> getAll();
    Optional<Template> getTemplateByName(String name);
    Optional<Template> getTemplateById(Long id);
}

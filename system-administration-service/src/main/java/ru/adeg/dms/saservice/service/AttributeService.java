package ru.adeg.dms.saservice.service;

import ru.adeg.dms.saservice.entity.Attribute;

import java.util.List;
import java.util.Optional;

public interface AttributeService {
    Attribute addAttribute(Attribute attribute);
    void delete(long id);
    List<Attribute> getAll();
    Optional<Attribute> getAttributeByName(String name);
    Optional<Attribute> getAttributeById(Long id);
}

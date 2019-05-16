package ru.adeg.dms.saservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adeg.dms.saservice.entity.Attribute;
import ru.adeg.dms.saservice.repository.AttributeRepository;
import ru.adeg.dms.saservice.service.AttributeService;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    private AttributeRepository attributeRepository;

    public Attribute addAttribute(Attribute attribute) {
        return attributeRepository.saveAndFlush(attribute);
    }

    public void delete(long id) {
        attributeRepository.deleteById(id);
    }

    public List<Attribute> getAll() {
        return attributeRepository.findAll();
    }

    public Optional<Attribute> getAttributeByName(String name) {
        return attributeRepository.findByName(name);
    }

    public Optional<Attribute> getAttributeById(Long id) {
        return attributeRepository.findById(id);
    }

}

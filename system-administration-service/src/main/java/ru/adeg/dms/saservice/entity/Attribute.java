package ru.adeg.dms.saservice.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data


@Entity(name = "Attribute")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attribute_id;

    @Column(name = "attribute_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "attribute", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<TemplateAttributes> templateAttributes = new HashSet<TemplateAttributes>(0);

    public Attribute() {}

    public Attribute(String name) {
        this.name = name;
    }

    public void addTemplate(Template template, Boolean isMandotory) {
        TemplateAttributes temp = new TemplateAttributes(template, this, isMandotory);
        templateAttributes.add(temp);
        template.getTemplateAttributes().add(temp);
    }

    public Long getId() {
        return attribute_id;
    }

    public void setId(Long attribute_id) {
        this.attribute_id = attribute_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TemplateAttributes> getTemplateAttributes() {
        return templateAttributes;
    }

    public void setTemplateAttributes(Set<TemplateAttributes> templateAttributes) {
        this.templateAttributes = templateAttributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attribute)) return false;
        Attribute attribute = (Attribute) o;
        return Objects.equals(getName(), attribute.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
